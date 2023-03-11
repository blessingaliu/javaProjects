package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Product;
import com.sg.flooringmastery.service.FlooringDataValidationException;

import java.util.List;

public interface ProductDao {

    public List<Product> getAllProducts() throws FlooringDataValidationException.FlooringPersistenceException;

    public Product getProductByType(String productType) throws FlooringDataValidationException.FlooringPersistenceException;

}
