package io.jgrecu;

import io.jgrecu.domain.Product;
import io.jgrecu.service.FileReaderService;
import io.jgrecu.service.ReportGenerator;

import java.util.ArrayList;

public class SimpleInventoryManagementSystemApp {
    public static void main(String[] args) {
        FileReaderService fileReaderService = FileReaderService.getInstance();
        ArrayList<Product> productList = fileReaderService.readProductsFromFile("sample-data.csv");

        ReportGenerator reportGenerator = ReportGenerator.getInstance();
        reportGenerator.generateLowInventoryReport(productList);
    }
}
