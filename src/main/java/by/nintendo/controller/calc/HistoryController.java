package by.nintendo.controller.calc;

import by.nintendo.storage.calc.HistoryStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/")
public class HistoryController {

    @Autowired
    @Qualifier(value = "inMemory")
    HistoryStorage historyStorage;

    @GetMapping(path = "/history")
    public ModelAndView history(ModelAndView modelAndView){
        modelAndView.addObject("history",historyStorage.getList());
        modelAndView.setViewName("history");
        return modelAndView;
    }
}
