from pyspark.sql import SparkSession
from pyspark.sql.functions import col, year, month, sum, avg, lit
from pyspark.ml.feature import VectorAssembler
from pyspark.ml.regression import LinearRegression
from pyspark.sql import functions as F

def ml_pipeline():
    spark = SparkSession.builder \
        .appName("MLPipelineHospital") \
        .master("local[*]") \
        .getOrCreate()

    # Caminho de entrada do arquivo unificado
    input_path = "data/processed/base_hospitalar.parquet"
    df = spark.read.parquet(input_path)

    # 1. **Internações históricas por especialidade**
    internacoes_feature = df.groupBy("especialidade", "ano", "mes") \
        .agg(sum("internacoes").alias("internacoes_hist"))

    # 2. **Demografia regional**
    # Já está no dataset como "uf" e "populacao"
    demografia_feature = df.select("uf", "populacao", "ano", "mes")

    # 3. **Sazonalidade de doenças**
    # Aqui, vamos usar a sazonalidade baseada no mês, por exemplo, somando internações por mês.
    sazonalidade_feature = df.groupBy("mes") \
        .agg(sum("internacoes").alias("internacoes_sazonais")) \
        .withColumn("sazonalidade_index", (col("internacoes_sazonais") / sum("internacoes_sazonais").over()).cast("double"))

    # 4. **Capacidade hospitalar**
    # Para simplificação, vamos usar a soma dos valores de cada especialidade.
    capacidade_hospitalar_feature = df.groupBy("especialidade") \
        .agg(sum("valor_total").alias("capacidade_hospitalar"))

    # 5. **Indicadores socioeconômicos**
    # Vamos juntar com a tabela de IBGE para agregar a população.
    indicadores_socioeconomicos_feature = df.join(demografia_feature, on=["uf", "ano", "mes"], how="left") \
        .select("uf", "ano", "mes", "populacao", "internacoes_hist")

    # **Unificando todas as features**
    df_features = internacoes_feature.join(demografia_feature, on=["especialidade", "ano", "mes"], how="left") \
                                     .join(sazonalidade_feature, on="mes", how="left") \
                                     .join(capacidade_hospitalar_feature, on="especialidade", how="left") \
                                     .join(indicadores_socioeconomicos_feature, on=["uf", "ano", "mes"], how="left")

    # **Preparação para Machine Learning**
    # Criando a coluna 'features' para ML
    feature_cols = ["internacoes_hist", "populacao", "sazonalidade_index", "capacidade_hospitalar"]
    assembler = VectorAssembler(inputCols=feature_cols, outputCol="features")
    df_features = assembler.transform(df_features)

    # **Modelo de Regressão Linear**
    lr = LinearRegression(featuresCol="features", labelCol="internacoes_hist")
    lr_model = lr.fit(df_features)

    # Fazendo previsões
    predictions = lr_model.transform(df_features)
    
    # Mostrando previsões
    predictions.select("ano", "mes", "especialidade", "prediction").show()

    # **Gerando Output para Dashboard**
    # Previsões de ocupação hospitalar (baseada em internações previstas)
    ocupacao_hospitalar = predictions.select("ano", "mes", "especialidade", "prediction") \
                                      .groupBy("ano", "mes", "especialidade") \
                                      .agg(avg("prediction").alias("previsao_ocupacao"))

    # Mapas de demanda por especialidade
    demanda_por_especialidade = df_features.groupBy("especialidade").agg(sum("internacoes_hist").alias("demanda_total"))

    # **Salvar os resultados**
    ocupacao_hospitalar.write.mode("overwrite").parquet("data/processed/ocupacao_hospitalar.parquet")
    demanda_por_especialidade.write.mode("overwrite").parquet("data/processed/demanda_por_especialidade.parquet")

    # Finaliza a sessão Spark
    spark.stop()

if __name__ == "__main__":
    ml_pipeline()