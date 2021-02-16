package by.nintendo.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

public class Calculator {
    @NotNull(message = "pppppppppp")
    private double numOne;
    @NotNull(message = "pppppppppp")
    private double numTwo;

    private String simbol;

    private double result;

    public Calculator() {
    }

    public Calculator(double numOne, double numTwo, String simbol) {
        this.numOne = numOne;
        this.numTwo = numTwo;
        this.simbol = simbol;
    }

    public Calculator(double numOne, double numTwo, String simbol, double result) {
        this.numOne = numOne;
        this.numTwo = numTwo;
        this.simbol = simbol;
        this.result = result;
    }

    public Calculator(@NotNull(message = "pppppppppp") double numOne) {
        this.numOne = numOne;
    }

    public double getNumOne() {
        return numOne;
    }

    public void setNumOne(double numOne) {
        this.numOne = numOne;
    }

    public double getNumTwo() {
        return numTwo;
    }

    public void setNumTwo(double numTwo) {
        this.numTwo = numTwo;
    }

    public String getSimbol() {
        return simbol;
    }

    public void setSimbol(String simbol) {
        this.simbol = simbol;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return  numOne + " "+simbol+" "+numTwo+" = "+result;
    }
}
