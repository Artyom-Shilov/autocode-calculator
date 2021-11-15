package com.epam.tat.calculator.impl;

import com.epam.tat.calculator.ICalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculator implements ICalculator {

    private int precision;
    private RoundingMode roundingMode;

    public Calculator(int precision) {
        this.precision = precision;
        this.roundingMode = RoundingMode.HALF_UP;
    }

    public Calculator() {
        this.precision = 5;
        this.roundingMode = RoundingMode.UP;
    }

    public Calculator(int precision, RoundingMode roundingMode) {
        this.precision = precision;
        this.roundingMode = roundingMode;
    }

    @Override
    public double add(double a, double b) {
        if (a == Double.MAX_VALUE && b == Double.MAX_VALUE) {
            return Double.POSITIVE_INFINITY;
        }
        if (a == -Double.MAX_VALUE && b == -Double.MAX_VALUE) {
            return Double.NEGATIVE_INFINITY;
        }
        return BigDecimal.valueOf(a + b).setScale(precision, roundingMode).doubleValue();
    }

    @Override
    public double subtract(double a, double b) {
        if (a == -Double.MAX_VALUE && b == Double.MAX_VALUE) {
            return Double.NEGATIVE_INFINITY;
        }
        if (a == Double.MAX_VALUE && b == -Double.MAX_VALUE) {
            return Double.POSITIVE_INFINITY;
        }
        return BigDecimal.valueOf(a - b).setScale(precision, roundingMode).doubleValue();
    }

    @Override
    public double multiply(double a, double b) {
        if ((a == Double.MAX_VALUE && b == Double.MAX_VALUE) || (a == -Double.MAX_VALUE && b == -Double.MAX_VALUE)) {
            return Double.POSITIVE_INFINITY;
        }
        if ((a == Double.MAX_VALUE && b == -Double.MAX_VALUE) || (a == -Double.MAX_VALUE && b == Double.MAX_VALUE)) {
            return Double.NEGATIVE_INFINITY;
        }
        return BigDecimal.valueOf(a * b).setScale(precision, roundingMode).doubleValue();
    }

    @Override
    public double divide(double a, double b) {
        if (b == 0) {
            return a / b;
        }
        return BigDecimal.valueOf(a / b).setScale(precision, roundingMode).doubleValue();
    }
}
