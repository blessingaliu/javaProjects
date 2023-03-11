package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Tax;
import com.sg.flooringmastery.service.FlooringDataValidationException;

import java.util.List;

public interface TaxDao {

    public List<Tax> getAllTaxes() throws FlooringDataValidationException.FlooringPersistenceException;

    public Tax getTax(String stateAbbreviation) throws FlooringDataValidationException.FlooringPersistenceException;

}
