package fr.univrouen.rss25SB.model;

import org.springframework.core.io.Resource;
import org.springframework.core.io.DefaultResourceLoader;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class TestRSS {
    private Resource resource;

    public TestRSS() {
        resource = new DefaultResourceLoader().getResource("classpath:xml/item.xml");
    }

    public String loadFileXML() {
        try (InputStream inputStream = resource.getInputStream();
             Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8)) {
            scanner.useDelimiter("\\A");
            return scanner.hasNext() ? scanner.next() : "";
        } catch (Exception e) {
            return "<error>Erreur lors de la lecture du fichier XML</error>";
        }
    }
}
