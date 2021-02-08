package by.nintendo.controller.authorithation;

import by.nintendo.model.User;
import by.nintendo.storage.user.UserInMemory;
import by.nintendo.storage.user.UserStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "/")
public class AuthorithationController {

    @Autowired
    @Qualifier("userInMemory")
    UserStorage userStorage;


/** Authorithation **/
    @GetMapping(path = "/author")
    public ModelAndView authorithView(ModelAndView modelAndView) {
        modelAndView.setViewName("authorithation");
        return modelAndView;
    }

    @PostMapping(path = "/auth")
    public ModelAndView authorithation(User user, ModelAndView modelAndView) {
        if (userStorage.userInMemori(user)) {
            System.out.println("uze est");
            modelAndView.setViewName("history");
        } else {
            userStorage.addInMemory(user);
            modelAndView.setViewName("index");
        }
        return modelAndView;
    }


    /** Registration **/

    @GetMapping(path = "/registrat")
    public ModelAndView registrationView(ModelAndView modelAndView) {
        modelAndView.setViewName("registration");
        return modelAndView;
    }
    @PostMapping(path = "/regist")
    public ModelAndView registration(User user, HttpSession httpSession ,ModelAndView modelAndView) {

        if (userStorage.checkLoginAndPassword(user)) {
            modelAndView.setViewName("index");
            httpSession.setAttribute("session",userStorage.getByLogin(user.getLogin()));
            modelAndView.addObject("sess",httpSession);
        } else {
            modelAndView.setViewName("calculator");
        }
        return modelAndView;
    }
}
