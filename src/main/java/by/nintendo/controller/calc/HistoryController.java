package by.nintendo.controller.calc;

import by.nintendo.entity.Calculator;
import by.nintendo.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "/")
public class HistoryController {


    @GetMapping(path = "/history")
    public ModelAndView history(ModelAndView modelAndView, User user, HttpSession session){
        modelAndView.addObject("history",((User) session.getAttribute("userSession")).getList());
        modelAndView.setViewName("history");
        return modelAndView;
    }
}
