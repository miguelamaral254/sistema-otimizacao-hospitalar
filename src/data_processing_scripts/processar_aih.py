import os
from pyspark.sql import SparkSession
from pyspark.sql.functions import col

def processar_aih():
    spark = SparkSession.builder \
        .appName("ProcessarAIH") \
        .master("local[*]") \
        .config("spark.sql.shuffle.partitions", "8") \
        .getOrCreate()

    base_path = "data/cleaned"
    arquivos = {
        "aih": "AIH_aprovadas_Especialidade_2024_ano_mes_limpo.csv"
    }

    def ler_csv(nome):
        return spark.read.option("header", True).option("sep", ";").csv(os.path.join(base_path, arquivos[nome]))

    # Lê o arquivo "aih"
    df_aih = ler_csv("aih").withColumnRenamed("aih_aprovadas", "aih")

    # Ajusta a coluna "ano_mes" sem fazer conversão de data
    df_aih = df_aih.withColumnRenamed(df_aih.columns[0], "ano_mes") \
                   .withColumnRenamed(df_aih.columns[1], "especialidade")

    # Caminho de saída para o AIH
    output_path = "data/processed/aih_processed.parquet"
    df_aih.write.mode("overwrite").parquet(output_path)

    # Finaliza a sessão Spark
    spark.stop()