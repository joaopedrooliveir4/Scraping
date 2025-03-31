package main.scraping;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ScraperService {
    private static final String URL = "https://www.gov.br/ans/pt-br/acesso-a-informacao/participacao-da-sociedade/atualizacao-do-rol-de-procedimentos";
    private static final String DOWNLOAD_DIR = "C:\\Users\\João Pedro\\IdeaProjects\\WebScraping\\src\\Downloads\\";

    public void scrapeAndDownload() throws IOException {
        // Conectar no site e fazer scraping
        Document doc = Jsoup.connect(URL).get();
        Elements pdfLinks = doc.select("a[href$=.pdf]");

        // Lista dos PDFs que você deseja baixar (URLs ou partes dos nomes dos arquivos)
        String[] targetPdfNames = {
                "Anexo_I_Rol_2021RN_465.2021_RN627L.2024",  // Nome do PDF desejado
                "Anexo_II_DUT_2021_RN_465.2021_RN628.2025_RN629.2025"  // Nome do PDF desejado
        };

        // Criar pasta de downloads, se não existir
        Path downloadPath = Paths.get(DOWNLOAD_DIR);
        if (!Files.exists(downloadPath)) {
            Files.createDirectories(downloadPath);
        }

        // Fazer o download apenas dos PDFs desejados
        for (Element link : pdfLinks) {
            String pdfUrl = link.absUrl("href");
            String fileName = pdfUrl.substring(pdfUrl.lastIndexOf("/") + 1);

            // Verificar se o nome do arquivo contém os termos específicos
            for (String targetName : targetPdfNames) {
                if (fileName.contains(targetName)) {
                    downloadPdf(pdfUrl, fileName);
                    break;
                }
            }
        }
    }

    private void downloadPdf(String pdfUrl, String fileName) throws IOException {
        URL url = new URL(pdfUrl);
        try (InputStream in = url.openStream();
             OutputStream out = new FileOutputStream(DOWNLOAD_DIR + fileName)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) != -1) {
                out.write(buffer, 0, length);
            }
        }
        System.out.println("Download concluído: " + fileName);
    }
}
