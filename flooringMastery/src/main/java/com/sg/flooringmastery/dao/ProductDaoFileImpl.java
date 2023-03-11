package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Product;
import com.sg.flooringmastery.service.FlooringDataValidationException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class ProductDaoFileImpl implements ProductDao {

    Map<String, Product> allProducts;
    private final String PRODUCT_FILE;
    private final String DELIMITER;

    public ProductDaoFileImpl() {
        allProducts = new HashMap<>();
        PRODUCT_FILE = "Data/Products.txt";
        DELIMITER = ",";
    }

    @Override
    public List<Product> getAllProducts() throws FlooringDataValidationException.FlooringPersistenceException {
        loadProducts();
        return new ArrayList<>(allProducts.values());
    }

    @Override
    public Product getProductByType(String productType) throws FlooringDataValidationException.FlooringPersistenceException {
        loadProducts();
        return allProducts.get(productType);
    }

    // Loading from product txt file
    private void loadProducts() throws FlooringDataValidationException.FlooringPersistenceException {
        Scanner sc;
        try {
            sc = new Scanner(new BufferedReader(new FileReader(PRODUCT_FILE)));
        } catch (FileNotFoundException e) {
            throw new FlooringDataValidationException.FlooringPersistenceException("Yikes! Could not load product data into memory");
        }
        // skipping header line
        sc.nextLine();

        // Reading file line by line, splitting into chunks at delimiter, assigning to Product Object
        while (sc.hasNextLine()) {
            String currentLine = sc.nextLine();
            String[] productTokens = currentLine.split(DELIMITER);
            Product productFromFile = new Product();
            productFromFile.setProductName(productTokens[0]);
            BigDecimal costPerSquareFoot = new BigDecimal(productTokens[1]).setScale(2, RoundingMode.HALF_UP);
            productFromFile.setCostPerSquareFoot(costPerSquareFoot);
            BigDecimal LaborCostPerSquareFoot = new BigDecimal(productTokens[2]).setScale(2, RoundingMode.HALF_UP);
            productFromFile.setLaborCostPerSquareFoot(LaborCostPerSquareFoot);

            // loading up the HashMap with Product Objects
            allProducts.put(productFromFile.getProductName(), productFromFile);
        }

        // Clean up
        sc.close();
    }

}
