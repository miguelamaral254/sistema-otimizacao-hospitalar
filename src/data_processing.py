from data_processing_scripts.processar_aih import processar_aih  # Importa a função do script AIH
from data_processing_scripts.processar_ibge import processar_ibge  # Importa a função do script IBGE
from data_processing_scripts.processar_obitos import processar_obitos  # Importa a função do script Óbitos
from data_processing_scripts.processar_dias_permanencia import processar_dias_permanencia  # Importa a função do script Dias de Permanência
from data_processing_scripts.processar_taxa_mortalidade import processar_taxa_mortalidade  # Importa a função do script Taxa de Mortalidade
from data_processing_scripts.processar_valor_total import processar_valor_total  # Importa a função do script Valor Total
from data_processing_scripts.processar_internacoes import processar_internacoes  # Importa a função do script Internações

def main():
    processar_aih()  
    processar_ibge()  
    processar_obitos()  
    processar_dias_permanencia()  
    processar_taxa_mortalidade()  
    processar_valor_total()  
    processar_internacoes()  

if __name__ == "__main__":
    main()