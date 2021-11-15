package com.epam.tat.calculator.impl;

import com.epam.tat.calculator.ICalculator;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculator implements ICalculator {

    private int precision;
    private RoundingMode roundingMode;

    public Calculator(int precision) {
        this.precision = precision;
        this.roundingMode = RoundingMode.HALF_DOWN;
    }

    public Calculator(){
        this.precision = 5;
        this.roundingMode = RoundingMode.HALF_DOWN;
    }

    public Calculator(int precision, RoundingMode roundingMode){
        this.precision = precision;
        this.roundingMode = roundingMode;
    }

    @Override
    public double add(double a, double b) {
        return BigDecimal.valueOf(a + b).setScale(precision, roundingMode).doubleValue();
    }

    @Override
    public double subtract(double a, double b) {
        return BigDecimal.valueOf(a - b).setScale(precision, roundingMode).doubleValue();
    }

    @Override
    public double multiply(double a, double b) {
        return BigDecimal.valueOf(a * b).setScale(precision, roundingMode).doubleValue();
    }

    @Override
    public double divide(double a, double b) {
        return BigDecimal.valueOf(a / b).setScale(precision, roundingMode).doubleValue();
    }
}
