package main.scraping;

import java.io.*;
import java.nio.file.*;
import java.util.zip.*;

public class Compressor {
    private static final String DOWNLOAD_DIR = "C:\\Users\\João Pedro\\IdeaProjects\\WebScraping\\src\\Downloads\\";
    private static final String OUTPUT_DIR = "C:\\Users\\João Pedro\\IdeaProjects\\WebScraping\\src\\output\\";

    public void compressPdfs() throws IOException {
        // Criar pasta de saída, se não existir
        Path outputPath = Paths.get(OUTPUT_DIR);
        if (!Files.exists(outputPath)) {
            Files.createDirectories(outputPath);
        }

        // Nome do arquivo ZIP
        String zipFileName = OUTPUT_DIR + "arquivos_compactados.zip";

        // Criar o arquivo ZIP
        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFileName))) {
            Files.walk(Paths.get(DOWNLOAD_DIR))
                    .filter(Files::isRegularFile)
                    .forEach(pdf -> {
                        try {
                            zipFile(pdf, zipOut);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        }
        System.out.println("Arquivos compactados para: " + zipFileName);
    }

    private void zipFile(Path filePath, ZipOutputStream zipOut) throws IOException {
        try (FileInputStream fis = new FileInputStream(filePath.toFile())) {
            ZipEntry zipEntry = new ZipEntry(filePath.getFileName().toString());
            zipOut.putNextEntry(zipEntry);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                zipOut.write(buffer, 0, length);
            }
            zipOut.closeEntry();
        }
    }
}