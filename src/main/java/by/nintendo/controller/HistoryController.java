package by.nintendo.controller;

import by.nintendo.storage.HistoryInMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/")
public class HistoryController {

    @Autowired
    HistoryInMemory historyInMemory;

    @GetMapping(path = "/history")
    public ModelAndView history(ModelAndView modelAndView){
        modelAndView.addObject("history",historyInMemory.getList());
        modelAndView.setViewName("history");
        return modelAndView;
    }
}
