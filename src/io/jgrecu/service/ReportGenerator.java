package io.jgrecu.service;

import io.jgrecu.domain.Product;

import java.util.ArrayList;

public class ReportGenerator {
    private static ReportGenerator instance;

    private ReportGenerator() {
    }

    public static ReportGenerator getInstance() {
        if (instance == null) {
            instance = new ReportGenerator();
        }
        return instance;
    }

    public void generateLowInventoryReport(ArrayList<Product> products) {
        products.stream()
                .filter(product ->
                        (product.getPrice() >= 0.99 && product.getPrice() <= 100 && product.getQuantity() < 20) ||
                                (product.getPrice() >= 101 && product.getQuantity() < 10)
                )
                .forEach(product -> System.out.println("id=" + product.getId() +
                        ", name=\'" + product.getName() +
                        "\', quantity=" + product.getQuantity() +
                        ", needs to be reordered!"));
    }
}
