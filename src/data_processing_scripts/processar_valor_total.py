import os
from pyspark.sql import SparkSession
from pyspark.sql.functions import col

def processar_valor_total():
    spark = SparkSession.builder \
        .appName("ProcessarValorTotal") \
        .master("local[*]") \
        .config("spark.sql.shuffle.partitions", "8") \
        .getOrCreate()

    base_path = "data/cleaned"
    arquivos = {
        "valor_total": "valor_total_especialidade_mensal_2024_limpo.csv"
    }

    def ler_csv(nome):
        return spark.read.option("header", True).option("sep", ";").csv(os.path.join(base_path, arquivos[nome]))

    # Lê o arquivo "valor_total"
    df_valor_total = ler_csv("valor_total").withColumnRenamed("valor_total", "valor_total")

    # Ajusta a coluna "ano_mes" sem fazer conversão de data
    df_valor_total = df_valor_total.withColumnRenamed(df_valor_total.columns[0], "ano_mes") \
                                   .withColumnRenamed(df_valor_total.columns[1], "especialidade")

    # Filtra os dados para remover o ano de 2024
    df_valor_total = df_valor_total.filter(col("ano_mes") != '2024')

    # Caminho de saída para o Valor Total
    output_path = "data/processed/valor_total_processed.parquet"
    df_valor_total.write.mode("overwrite").parquet(output_path)

    # Finaliza a sessão Spark
    spark.stop()

if __name__ == "__main__":
    processar_valor_total()