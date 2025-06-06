from pyspark.sql import SparkSession

def main():
    spark = SparkSession.builder \
        .appName("Read SIH Parquet") \
        .getOrCreate()
    parquet_path = "data/processed/sih.parquet"

    df = spark.read.parquet(parquet_path)

    total_rows = df.count()

    df.show(total_rows, truncate=False)

    spark.stop()

if __name__ == "__main__":
    main()