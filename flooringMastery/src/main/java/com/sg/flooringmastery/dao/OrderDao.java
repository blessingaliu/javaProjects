package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.service.FlooringDataValidationException;

import java.time.LocalDate;
import java.util.List;

public interface OrderDao {

    public Order createOrder(Order order) throws FlooringDataValidationException.FlooringPersistenceException;

    public Order getOrderById(LocalDate date, int orderNumber) throws FlooringDataValidationException.FlooringPersistenceException;

    public List<Order> getAllOrdersByDate(LocalDate date) throws FlooringDataValidationException.FlooringPersistenceException;

    public List<Order> getAllOrders() throws FlooringDataValidationException.FlooringPersistenceException;

    public Order updateOrder(Order order) throws FlooringDataValidationException.FlooringPersistenceException;

    public Order deleteOrder(LocalDate date, int orderNumber) throws FlooringDataValidationException.FlooringPersistenceException;

    public void exportAllOrders() throws FlooringDataValidationException.FlooringPersistenceException;

}
