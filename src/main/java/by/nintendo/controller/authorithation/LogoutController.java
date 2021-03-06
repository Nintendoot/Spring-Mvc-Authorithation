package by.nintendo.controller.authorithation;

import by.nintendo.entity.User;
import by.nintendo.servise.calculator.CalculatorServise;
import by.nintendo.storage.calc.HistoryStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "/")
public class LogoutController {

    @Autowired
    @Qualifier("historyInMemory")
    HistoryStorage historyStorage;

    @GetMapping(path = "/logout")
    public ModelAndView logout(HttpSession session, ModelAndView modelAndView) {
        historyStorage.addInList((User) session.getAttribute("userSession"));
        session.invalidate();
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
