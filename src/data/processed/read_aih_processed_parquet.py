from pyspark.sql import SparkSession

def main():
    spark = SparkSession.builder \
        .appName("Read AIH Parquet") \
        .getOrCreate()
    
    # Caminho para o arquivo Parquet gerado pelo processamento do AIH
    parquet_path = "data/processed/aih_processed.parquet"

    # Lê o arquivo Parquet
    df = spark.read.parquet(parquet_path)

    # Conta o número de linhas no DataFrame
    total_rows = df.count()

    # Exibe as linhas do DataFrame
    df.show(total_rows, truncate=False)

    # Finaliza a sessão Spark
    spark.stop()

if __name__ == "__main__":
    main()