package com.sg.flooringmastery.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class Tax {

    private String stateAbbreviation;
    private String stateName;
    private BigDecimal taxRate;

    public String getStateAbbreviation() {
        return stateAbbreviation;
    }

    public void setStateAbbrevation(String stateAbbrevation) {
        this.stateAbbreviation = stateAbbrevation;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    @Override
    public String toString() {
        return "Tax{" + "stateAbbrevation=" + stateAbbreviation + ", stateName=" + stateName + ", taxRate=" + taxRate + '}';
    }

    // hashcode implementation
    // hash code method that returns an int
    @Override
    public int hashCode() {
        // start with a non-zero constant, preferably a prime number
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.stateAbbreviation);
        hash = 59 * hash + Objects.hashCode(this.stateName);
        hash = 59 * hash + Objects.hashCode(this.taxRate);
        return hash;
    }

    // equals method to check if different objects are each to each other
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tax other = (Tax) obj;
        if (!Objects.equals(this.stateAbbreviation, other.stateAbbreviation)) {
            return false;
        }
        if (!Objects.equals(this.stateName, other.stateName)) {
            return false;
        }
        if (!Objects.equals(this.taxRate, other.taxRate)) {
            return false;
        }
        return true;
    }

}
