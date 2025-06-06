import os
import json
from loaders.ibge_data_loader import fetch_ibge_data
from processors.aih_data_processor import processar_aih
from processors.obitos_data_processor import processar_obitos
from processors.internacoes_data_processor import processar_internacoes
from processors.dias_permanencia_data_processor import processar_dias_permanencia
from processors.taxa_mortalidade_data_processor import processar_taxa_mortalidade
from processors.valor_total_data_processor import processar_valor_total

def run_data_collection():
    print("🔍 Iniciando coleta e processamento de dados do DATASUS e IBGE...")

    os.makedirs("data/raw", exist_ok=True)
    os.makedirs("data/cleaned", exist_ok=True)

    ibge_data = fetch_ibge_data()
    ibge_output_path = "data/cleaned/ibge.json"
    with open(ibge_output_path, "w", encoding="utf-8") as f:
        json.dump(ibge_data, f, ensure_ascii=False, indent=2)

    processar_aih()
    processar_obitos()
    processar_internacoes()
    processar_dias_permanencia()
    processar_taxa_mortalidade()
    processar_valor_total()

    print(f"\n📁 Dados do IBGE salvos em: {ibge_output_path}")
    print("✅ Coleta e processamento finalizados com sucesso.")

if __name__ == "__main__":
    run_data_collection()