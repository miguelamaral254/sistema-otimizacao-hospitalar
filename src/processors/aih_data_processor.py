import pandas as pd
import os

def processar_aih():
    input_path = "data/raw/AIH_aprovadas_Especialidade_2024_ano_mes_processamento.csv"
    output_path = "data/cleaned/AIH_aprovadas_Especialidade_2024_ano_mes_limpo.csv"

    if not os.path.exists(input_path):
        raise FileNotFoundError(f"❌ Arquivo não encontrado em: {os.path.abspath(input_path)}")

    # Leitura do arquivo CSV
    df = pd.read_csv(input_path, sep=';', encoding='latin1', skiprows=3)
    df.columns = df.columns.str.strip().str.lower().str.replace(' ', '_')

    # Remove rodapés e comentários inúteis, mantendo a linha "Total"
    df = df[~df.iloc[:, 0].astype(str).str.contains('Fonte|Notas|classificação|jurídica|situação|dados|regime', case=False, na=False)]

    # Remover a linha com '2024' na coluna 'ano/mês_processamento'
    df = df[df['ano/mês_processamento'] != '2024']

    # Salva o arquivo limpo
    os.makedirs(os.path.dirname(output_path), exist_ok=True)
    df.to_csv(output_path, sep=';', index=False, encoding='utf-8')

    print(f"✅ Processamento concluído com sucesso!")
    print(f"📌 Arquivo salvo em: {os.path.abspath(output_path)}")
    print(f"📊 Total de registros (incluindo Total): {len(df)}")

if __name__ == "__main__":
    processar_aih()