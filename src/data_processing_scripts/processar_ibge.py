import os
from pyspark.sql import SparkSession
from pyspark.sql.functions import col

def processar_ibge():
    spark = SparkSession.builder \
        .appName("ProcessarIBGE") \
        .master("local[*]") \
        .config("spark.sql.shuffle.partitions", "8") \
        .getOrCreate()

    base_path = "data/cleaned"
    arquivos = {
        "ibge": "ibge.json"
    }

    # Carrega dados do IBGE
    df_ibge = spark.read.option("multiline", "true").json(os.path.join(base_path, arquivos["ibge"]))
    
    # Filtra as colunas e renomeia conforme necessário
    df_ibge = df_ibge.selectExpr("D1N as uf", "D3N as ano", "V as populacao") \
                     .withColumn("ano", col("ano").cast("int")) \
                     .withColumn("populacao", col("populacao").cast("int")) \
                     .filter(col("ano") == 2024)

    # Caminho de saída para o IBGE
    output_path = "data/processed/ibge_processed.parquet"
    df_ibge.write.mode("overwrite").parquet(output_path)

    # Finaliza a sessão Spark
    spark.stop()