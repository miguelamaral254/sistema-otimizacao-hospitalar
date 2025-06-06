import os
from pyspark.sql import SparkSession
from pyspark.sql.functions import col

def processar_obitos():
    spark = SparkSession.builder \
        .appName("ProcessarObitos") \
        .master("local[*]") \
        .config("spark.sql.shuffle.partitions", "8") \
        .getOrCreate()

    base_path = "data/cleaned"
    arquivos = {
        "obitos": "obitos_especialidade_2024_limpo.csv"
    }

    def ler_csv(nome):
        return spark.read.option("header", True).option("sep", ";").csv(os.path.join(base_path, arquivos[nome]))

    # Lê o arquivo "obitos"
    df_obitos = ler_csv("obitos").withColumnRenamed("óbito", "obitos")

    # Ajusta a coluna "ano_mes" sem fazer conversão de data
    df_obitos = df_obitos.withColumnRenamed(df_obitos.columns[0], "ano_mes") \
                         .withColumnRenamed(df_obitos.columns[1], "especialidade")

    # Filtra os dados para remover o ano de 2024
    df_obitos = df_obitos.filter(col("ano_mes") != '2024')

    # Caminho de saída para o Obitos
    output_path = "data/processed/obitos_processed.parquet"
    df_obitos.write.mode("overwrite").parquet(output_path)

    # Finaliza a sessão Spark
    spark.stop()

if __name__ == "__main__":
    processar_obitos()