package io.jgrecu;

import io.jgrecu.domain.Product;
import io.jgrecu.service.CSVReader;
import io.jgrecu.service.ReportGenerator;

import java.util.ArrayList;

public class SimpleInventoryManagementSystemApp {
    public static void main(String[] args) {
        CSVReader csvReader = CSVReader.getInstance();
        ArrayList<Product> productList = csvReader.readProductsFromFile("sample-data.csv");

        ReportGenerator reportGenerator = ReportGenerator.getInstance();
        reportGenerator.generateLowInventoryReport(productList);
    }
}
