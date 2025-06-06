import os

def fetch_sih_data_from_csv():
    print("📂 Verificando arquivo CSV local de internações hospitalares (SIH)...")

    sih_path = "data/raw/sih_cnv_niuf144827200_124_166_242.csv"

    if not os.path.exists(sih_path):
        raise FileNotFoundError(f"❌ Arquivo SIH não encontrado em: {sih_path}")

    try:
        with open(sih_path, encoding='latin1') as f:
            _ = f.read(1000)
    except Exception as e:
        raise Exception(f"❌ Erro ao ler arquivo SIH: {e}")

    print("✅ Arquivo SIH encontrado e legível.")
    return sih_path
