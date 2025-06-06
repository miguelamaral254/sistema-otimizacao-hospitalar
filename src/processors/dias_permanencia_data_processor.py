import pandas as pd
import os

def processar_dias_permanencia():
    try:
        input_path = "data/raw/dias_permanencia_especialidade_2024.csv"
        output_path = "data/cleaned/dias_permanencia_especialidade_2024_limpo.csv"

        if not os.path.exists(input_path):
            raise FileNotFoundError(f"❌ Arquivo não encontrado: {os.path.abspath(input_path)}")

        df = pd.read_csv(
            input_path,
            sep=';',
            encoding='latin1',
            skiprows=3
        )

        df.columns = df.columns.str.strip().str.lower().str.replace(' ', '_')

        # Remove apenas rodapés e observações irrelevantes
        df = df[~df.iloc[:, 0].astype(str).str.contains('Fonte|Notas|classificação|jurídica|situação|regime|dados', case=False, na=False)]

        # Remove a linha com '2024' na coluna 'ano/mês_processamento' (ou equivalente)
        df = df[df['ano/mês_processamento'] != '2024']

        # Converte a coluna 'dias_de_permanência' para numérico, tratando erros
        if 'dias_de_permanência' in df.columns:
            df['dias_de_permanência'] = pd.to_numeric(df['dias_de_permanência'], errors='coerce')

        # Cria o diretório de saída, caso não exista
        os.makedirs(os.path.dirname(output_path), exist_ok=True)

        # Salva o arquivo limpo
        df.to_csv(output_path, sep=';', index=False, encoding='utf-8')

        print(f"✅ Dias de permanência processados com sucesso!")
        print(f"📁 Arquivo limpo salvo em: {os.path.abspath(output_path)}")
        print(f"📊 Total de registros (incluindo 'Total' se houver): {len(df)}")

    except Exception as e:
        print(f"❌ Erro ao processar dias de permanência: {str(e)}")

if __name__ == "__main__":
    processar_dias_permanencia()