package com.sg.flooringmastery.service;

import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.dto.Product;
import com.sg.flooringmastery.dto.Tax;

import java.time.LocalDate;
import java.util.List;

public interface FlooringServiceLayer {

    public Order addOrder(Order order) throws FlooringDataValidationException.FlooringPersistenceException;

    public void saveAllOrdersToBackUp() throws FlooringDataValidationException.FlooringPersistenceException;

    public List<Order> getOrdersByDate(LocalDate date) throws FlooringDataValidationException.FlooringPersistenceException, NoOrderExistsException;

    public Order getOrder(LocalDate date, int orderNumber) throws FlooringDataValidationException.FlooringPersistenceException, NoOrderExistsException ;

    public Order editOrder(Order order) throws FlooringDataValidationException.FlooringPersistenceException, NoOrderExistsException;

    public Order removeOrder(Order order) throws FlooringDataValidationException.FlooringPersistenceException, NoOrderExistsException;

    public Order validateAndCalculateTempOrder(Order order) throws FlooringDataValidationException.FlooringPersistenceException, FlooringDataValidationException;

    public List<Tax> getAllStates() throws FlooringDataValidationException.FlooringPersistenceException;

    public List<Product> getAllProducts() throws FlooringDataValidationException.FlooringPersistenceException;

}
