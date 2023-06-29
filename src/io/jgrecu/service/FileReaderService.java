package io.jgrecu.service;

import io.jgrecu.domain.Product;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileReaderService {
    private static FileReaderService instance;

    private FileReaderService() {
    }

    public static FileReaderService getInstance() {
        if (instance == null) {
            instance = new FileReaderService();
        }
        return instance;
    }

    public List<Product> readProductsFromFile(String fileName) {
        List<Product> products = new ArrayList<>();
        Path filePath = Path.of(fileName);
        try {
            List<String> allLines = Files.readAllLines(filePath);
            allLines.stream()
                    .skip(1)
                    .map(line -> line.split(","))
                    .map(line -> new Product(
                            Integer.parseInt(line[0]),
                            line[1], Integer.parseInt(line[2]),
                            Double.parseDouble(line[3])
                    ))
                    .forEach(products::add);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            e.printStackTrace();
            return List.of();
        }
        return products;
    }
}
