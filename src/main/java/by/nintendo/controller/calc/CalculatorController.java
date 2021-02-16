package by.nintendo.controller.calc;

import by.nintendo.entity.Calculator;
import by.nintendo.entity.User;
import by.nintendo.servise.calculator.CalculatorServise;
import by.nintendo.storage.calc.HistoryStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(path = "/")
public class CalculatorController {

    @Autowired
    @Qualifier("calculatorImplement")
    CalculatorServise calculatorServise;

    @GetMapping(path = "/calculator")
    public ModelAndView culcView(ModelAndView modelAndView) {
        modelAndView.addObject("newCalculator", new Calculator());
        modelAndView.setViewName("calculator");
        return modelAndView;
    }

    @PostMapping(path = "/calculat")
    public ModelAndView calculayor(@Valid @ModelAttribute("newCalculator") Calculator calculator, BindingResult result, ModelAndView modelAndView, HttpSession session) {
        if (result.hasErrors()) {
            Map<String, String> errorsCalc = new HashMap<>();
            for (FieldError fieldError : result.getFieldErrors()) {
                errorsCalc.put(fieldError.getField(), fieldError.getDefaultMessage());
                modelAndView.addObject("errorsCalc", errorsCalc);
                modelAndView.setViewName("calculator");
            }
        } else {
            calculatorServise.calc(calculator);
            ((User) session.getAttribute("userSession")).addList(calculator);
            modelAndView.addObject("calculator", calculator);
            modelAndView.setViewName("calculator");
        }
        return modelAndView;
    }
}
