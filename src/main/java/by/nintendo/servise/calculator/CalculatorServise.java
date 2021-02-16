package by.nintendo.servise.calculator;

import by.nintendo.entity.Calculator;

import java.util.List;

public interface CalculatorServise {
    void calc(Calculator calculator);
    void addCalc(Calculator calculator);
    List<Calculator> getAllList();
}
