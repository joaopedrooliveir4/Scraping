# Projeto de Web Scraping e Compressão de PDFs

Este projeto realiza o scraping de dois arquivos PDF específicos do site da ANS, os compacta em um arquivo ZIP e os armazena em diretórios apropriados.

## Funcionalidades
- **Scraping**: O código acessa o site da ANS e faz o download de dois PDFs específicos.
- **Compressão**: Os PDFs baixados são compactados em um único arquivo ZIP.
- **Estrutura de Pastas**:
    - **Downloads/**: Contém os arquivos PDF baixados.
    - **output/**: Contém o arquivo ZIP gerado após a compressão.

## Estrutura do Código
O código é simples e estruturado em três classes principais:
1. **ScraperService.java**: Responsável por fazer o scraping do site e baixar os PDFs.
2. **Compressor.java**: Responsável por compactar os PDFs baixados em um arquivo ZIP.
3. **Main.java**: Serve como ponto de entrada, coordenando as ações de scraping e compressão.

## Considerações
- O código foi feito de forma simples e concisa, com o objetivo de manter o número de arquivos baixo. No entanto, **para um maior número de arquivos ou requisições**, pode ser necessário adicionar novas funcionalidades e otimizações, especialmente em termos de **performance** e **escabilidade**.
- A implementação de **variáveis de ambiente** para armazenar URLs foi planejada visando **segurança**, evitando o hardcoding de informações sensíveis no código. Contudo, **por problemas nas configurações** dessas variáveis, não foi possível integrá-las corretamente neste momento. **Estou ciente do problema e irei analisá-lo e corrigi-lo**.
   
## Baixar a biblioteca Jsoup manualmente:
## A biblioteca Jsoup foi baixada manualmente, sem o uso de ferramentas de gerenciamento de dependências como Maven ou Gradle. Você pode obter a versão mais recente do Jsoup em https://jsoup.org/download.
## Após o download do arquivo JAR do Jsoup, adicione-o ao seu classpath no projeto.

## Exemplo de saída para fácil avaliação:

**Download concluído: Anexo_I_Rol_2021RN_465.2021_RN627L.2024.pdf
Download concluído: Anexo_II_DUT_2021_RN_465.2021_RN628.2025_RN629.2025.pdf
Arquivos compactados para: \output\arquivos_compactados.zip**

## Arquivos Gerados:

Os PDFs serão baixados para a pasta Downloads/.

O arquivo ZIP será gerado na pasta output/.

Dependências
**Java 11+:** Certifique-se de ter o JDK 11 ou superior instalado.

**Biblioteca Jsoup:** Utilizada para o scraping da página da ANS. Foi baixada manualmente e adicionada ao classpath do projeto. (Sem Maven ou Gradle).

## Notas de Desenvolvimento
O projeto foi desenvolvido com o objetivo de ser simples e direto.

Planejei funcionalidades como o uso de variáveis de ambiente para segurança, mas ainda estou em processo de resolver problemas de configuração.

## Licença
Este projeto está licenciado sob a Licença MIT - veja o arquivo LICENSE para mais detalhes.