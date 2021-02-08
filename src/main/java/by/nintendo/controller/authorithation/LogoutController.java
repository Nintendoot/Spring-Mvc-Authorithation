package by.nintendo.controller.authorithation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "/")
public class LogoutController {
    @GetMapping(path = "/logout")
    public ModelAndView logout(HttpSession session,ModelAndView modelAndView){
        session.invalidate();
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
