import os
from pyspark.sql import SparkSession
from pyspark.sql.functions import col

def processar_internacoes():
    spark = SparkSession.builder \
        .appName("ProcessarInternacoes") \
        .master("local[*]") \
        .config("spark.sql.shuffle.partitions", "8") \
        .getOrCreate()

    base_path = "data/cleaned"
    arquivos = {
        "internacoes": "internacoes_especialidade_2024_limpo.csv"
    }

    def ler_csv(nome):
        return spark.read.option("header", True).option("sep", ";").csv(os.path.join(base_path, arquivos[nome]))

    # Lê o arquivo "internacoes"
    df_internacoes = ler_csv("internacoes").withColumnRenamed("internações", "internacoes")

    # Ajusta a coluna "ano_mes" sem fazer conversão de data
    df_internacoes = df_internacoes.withColumnRenamed(df_internacoes.columns[0], "ano_mes") \
                                   .withColumnRenamed(df_internacoes.columns[1], "especialidade")

    # Filtra os dados para remover o ano de 2024
    df_internacoes = df_internacoes.filter(col("ano_mes") != '2024')

    # Caminho de saída para as Internações
    output_path = "data/processed/internacoes_processed.parquet"
    df_internacoes.write.mode("overwrite").parquet(output_path)

    # Finaliza a sessão Spark
    spark.stop()

if __name__ == "__main__":
    processar_internacoes()