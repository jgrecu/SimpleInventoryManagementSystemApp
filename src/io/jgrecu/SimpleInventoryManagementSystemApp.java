package io.jgrecu;

import io.jgrecu.domain.Product;
import io.jgrecu.service.FileReaderService;

import java.util.List;

public class SimpleInventoryManagementSystemApp {
    public static void main(String[] args) {
        FileReaderService fileReaderService = FileReaderService.getInstance();
        List<Product> productList = fileReaderService.readProductsFromFile("sample-data.csv");
        productList.forEach(System.out::println);
    }
}
