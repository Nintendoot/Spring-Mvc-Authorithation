package by.nintendo.controller;

import by.nintendo.model.Calculator;
import by.nintendo.servise.calculator.CalculatorServise;
import by.nintendo.storage.HistoryInMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/")
public class CalculatorController {
    @Autowired
    CalculatorServise calculatorServise;
    @Autowired
    HistoryInMemory historyInMemory;
    @GetMapping(path = "/calculator")
    public ModelAndView culcView(ModelAndView modelAndView) {
        modelAndView.setViewName("calculator");
        return modelAndView;
    }

    @PostMapping(path = "/calculat")
    public ModelAndView calculayor(Calculator calculator, ModelAndView modelAndView) {
        calculatorServise.calc(calculator);
        historyInMemory.addInList(calculator);
        modelAndView.addObject("calculator", calculator);
        modelAndView.setViewName("calculator");
        return modelAndView;
    }
}
