import pandas as pd
import os

def processar_taxa_mortalidade():
    try:
        input_path = "data/raw/taxa_mortalidade_especialidade_mensal_2024.csv"
        output_path = "data/cleaned/taxa_mortalidade_especialidade_mensal_2024_limpo.csv"

        if not os.path.exists(input_path):
            raise FileNotFoundError(f"❌ Arquivo não encontrado: {os.path.abspath(input_path)}")

        df = pd.read_csv(
            input_path,
            sep=';',
            encoding='latin1',
            skiprows=3
        )

        df.columns = df.columns.str.strip().str.lower().str.replace(' ', '_')

        df = df[~df.iloc[:, 0].astype(str).str.contains('Fonte|Notas|classificação|jurídica|situação|regime|dados', case=False, na=False)]
        df = df[df['ano/mês_processamento'] != '2024']
        
        if 'taxa_de_mortalidade' in df.columns:
            df['taxa_de_mortalidade'] = pd.to_numeric(df['taxa_de_mortalidade'], errors='coerce')

        os.makedirs(os.path.dirname(output_path), exist_ok=True)
        df.to_csv(output_path, sep=';', index=False, encoding='utf-8')

        print(f"✅ Taxa de mortalidade processada com sucesso!")
        print(f"📁 Arquivo limpo salvo em: {os.path.abspath(output_path)}")
        print(f"📊 Total de registros: {len(df)}")

    except Exception as e:
        print(f"❌ Erro ao processar taxa de mortalidade: {str(e)}")