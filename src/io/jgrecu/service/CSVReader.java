package io.jgrecu.service;

import io.jgrecu.domain.Product;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    private static CSVReader instance;

    private CSVReader() {
    }

    public static CSVReader getInstance() {
        if (instance == null) {
            instance = new CSVReader();
        }
        return instance;
    }

    public ArrayList<Product> readProductsFromFile(String fileName) {
        ArrayList<Product> products = new ArrayList<>();
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
            return new ArrayList<>();
        }
        return products;
    }
}
