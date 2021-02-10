package by.nintendo.servise.calculator;

import by.nintendo.entity.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CalculatorImplement implements CalculatorServise {
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
}

