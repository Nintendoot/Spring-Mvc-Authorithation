package by.nintendo.servise.calculator;

import by.nintendo.entity.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CalculatorImplement implements CalculatorServise {
    private static final List<Calculator> calcList=new ArrayList<>();

    @Autowired
    public CalculatorImplement() {
    }

    @Override
    public void calc(Calculator calculator) {
        double resoult;
        switch (calculator.getSimbol()) {
            case "+":
                resoult = calculator.getNumOne() + calculator.getNumTwo();
                break;

            case "*":
                resoult = calculator.getNumOne() * calculator.getNumTwo();
                break;

            case "-":
                resoult = calculator.getNumOne() - calculator.getNumTwo();
                break;

            case "/":
                resoult = calculator.getNumOne() / calculator.getNumTwo();
                break;
            default:
                resoult = 0;
        }

        calculator.setResult(resoult);

    }

    @Override
    public void addCalc(Calculator calculator) {
       calcList.add(calculator);
    }

    @Override
    public List<Calculator> getAllList() {

        return calcList;
    }
}

