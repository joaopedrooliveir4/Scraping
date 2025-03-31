package main.scraping;

public class Main {
    public static void main(String[] args) {
        try {
            // Instancia e executa o ScraperService para baixar os PDFs
            ScraperService scraper = new ScraperService();
            scraper.scrapeAndDownload(); // Chama o método

            // Instancia e executa o Compressor para compactar os PDFs
            Compressor compressor = new Compressor();
            compressor.compressPdfs();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
