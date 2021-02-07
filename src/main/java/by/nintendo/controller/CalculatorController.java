package by.nintendo.controller;

import by.nintendo.model.Calculator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/culc")
public class CalculatorController {

    @GetMapping(path = "/calculator")
    public ModelAndView culcView(ModelAndView modelAndView){
        modelAndView.setViewName("calculator");
        return modelAndView;
    }

    @PostMapping(path = "calculat")
    public ModelAndView calculayor(Calculator calculator,ModelAndView){

    }
}
