package by.nintendo.controller.authorithation;

import by.nintendo.storage.calc.HistoryStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/")
public class HistoryUserCalculatorController {

    @Autowired
    @Qualifier("historyInMemory")
    HistoryStorage historyStorage;

    @GetMapping("/histor")
    public ModelAndView usersHistory(ModelAndView modelAndView) {
        modelAndView.setViewName("usersHistory");
        modelAndView.addObject("usersHistory", historyStorage.getAllList());
        return modelAndView;
    }
}
