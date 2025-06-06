import pandas as pd
import os

def processar_obitos():
    try:
        input_path = "data/raw/obitos_especialidade_2024.csv"
        output_path = "data/cleaned/obitos_especialidade_2024_limpo.csv"

        if not os.path.exists(input_path):
            raise FileNotFoundError(f"❌ Arquivo não encontrado: {os.path.abspath(input_path)}")

        df = pd.read_csv(
            input_path,
            sep=';',
            encoding='latin1',
            skiprows=3
        )

        df.columns = df.columns.str.strip().str.lower().str.replace(' ', '_')

        # Remove apenas metadados e observações desnecessárias
        df = df[~df.iloc[:, 0].astype(str).str.contains('Fonte|Notas|classificação|jurídica|situação|regime|dados', case=False, na=False)]
        df = df[df['ano/mês_processamento'] != '2024']
        
        if 'óbito' in df.columns:
            df['óbito'] = pd.to_numeric(df['óbito'], errors='coerce')

        os.makedirs(os.path.dirname(output_path), exist_ok=True)
        df.to_csv(output_path, sep=';', index=False, encoding='utf-8')

        print(f"✅ Óbitos processados com sucesso!")
        print(f"📁 Arquivo limpo salvo em: {os.path.abspath(output_path)}")
        print(f"📊 Total de registros (incluindo 'Total' se houver): {len(df)}")

    except Exception as e:
        print(f"❌ Erro ao processar óbitos: {str(e)}")

if __name__ == "__main__":
    processar_obitos()