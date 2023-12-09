import xml.etree.ElementTree as ET

def analyze_jmeter_results(file_path):
    try:
        tree = ET.parse(file_path)
        root = tree.getroot()

        success_count = 0
        failure_count = 0

        for sample in root.findall('.//httpSample'):
            if sample.get('s') == 'true':
                success_count += 1
            else:
                failure_count += 1

        print("Análise dos Resultados do JMeter:")
        print(f"Testes bem-sucedidos: {success_count}")
        print(f"Testes com falha: {failure_count}")

        if failure_count > 0:
            print("Foram encontradas falhas nos testes.")
            exit(1)

    except Exception as e:
        print(f"Erro ao analisar o arquivo XML: {e}")
        exit(1)

if __name__ == "__main__":
    analyze_jmeter_results('./jmeter/results.xml')
