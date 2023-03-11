package com.sg.flooringmastery.view;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface UserIO {

    void print(String message);

    String readString(String prompt);

    String mustReadString(String prompt);

    int readInt(String prompt);

    int readInt(String prompt, int min, int max);

    double readDouble(String prompt);

    double readDouble(String prompt, double min, double max);

    float readFloat(String prompt);

    float readFloat(String prompt, float min, float max);

    long readLong(String prompt);

    long readLong(String prompt, long min, long max);

    boolean readBoolean(String prompt);

    LocalDate readLocalDate(String prompt);

    LocalDate readLocalDate(String prompt, LocalDate min, LocalDate max);

    BigDecimal readBigDecimal(String prompt);

    BigDecimal readBigDecimal(String prompt, BigDecimal min, BigDecimal max);

}
