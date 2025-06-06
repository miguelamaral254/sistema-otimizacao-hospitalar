import os
from pyspark.sql import SparkSession
from pyspark.sql.functions import col

def processar_dias_permanencia():
    spark = SparkSession.builder \
        .appName("ProcessarDiasPermanencia") \
        .master("local[*]") \
        .config("spark.sql.shuffle.partitions", "8") \
        .getOrCreate()

    base_path = "data/cleaned"
    arquivos = {
        "dias_permanencia": "dias_permanencia_especialidade_2024_limpo.csv"
    }

    def ler_csv(nome):
        return spark.read.option("header", True).option("sep", ";").csv(os.path.join(base_path, arquivos[nome]))

    # Lê o arquivo "dias_permanencia"
    df_dias = ler_csv("dias_permanencia").withColumnRenamed("dias_de_permanência", "dias_permanencia")

    # Ajusta a coluna "ano_mes"
    df_dias = df_dias.withColumnRenamed(df_dias.columns[0], "ano_mes") \
                     .withColumnRenamed(df_dias.columns[1], "especialidade")

    # Caminho de saída para o Dias de Permanência
    output_path = "data/processed/dias_permanencia_processed.parquet"
    df_dias.write.mode("overwrite").parquet(output_path)

    # Finaliza a sessão Spark
    spark.stop()