import os
from pyspark.sql import SparkSession
from pyspark.sql.functions import col

def processar_taxa_mortalidade():
    spark = SparkSession.builder \
        .appName("ProcessarTaxaMortalidade") \
        .master("local[*]") \
        .config("spark.sql.shuffle.partitions", "8") \
        .getOrCreate()

    base_path = "data/cleaned"
    arquivos = {
        "taxa_mortalidade": "taxa_mortalidade_especialidade_mensal_2024_limpo.csv"
    }

    def ler_csv(nome):
        return spark.read.option("header", True).option("sep", ";").csv(os.path.join(base_path, arquivos[nome]))

    # Lê o arquivo "taxa_mortalidade"
    df_taxa_mortalidade = ler_csv("taxa_mortalidade").withColumnRenamed("taxa_de_mortalidade", "taxa_mortalidade")

    # Ajusta a coluna "ano_mes" sem fazer conversão de data
    df_taxa_mortalidade = df_taxa_mortalidade.withColumnRenamed(df_taxa_mortalidade.columns[0], "ano_mes") \
                                             .withColumnRenamed(df_taxa_mortalidade.columns[1], "especialidade")

    # Filtra os dados para remover o ano de 2024
    df_taxa_mortalidade = df_taxa_mortalidade.filter(col("ano_mes") != '2024')

    # Caminho de saída para a Taxa de Mortalidade
    output_path = "data/processed/taxa_mortalidade_processed.parquet"
    df_taxa_mortalidade.write.mode("overwrite").parquet(output_path)

    # Finaliza a sessão Spark
    spark.stop()

if __name__ == "__main__":
    processar_taxa_mortalidade()