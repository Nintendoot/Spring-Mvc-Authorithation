package by.nintendo.controller.authorithation;

import by.nintendo.entity.User;
import by.nintendo.entity.UserModel;
import by.nintendo.exeption.NoSuchUserExeption;
import by.nintendo.storage.calc.HistoryStorage;
import by.nintendo.storage.user.UserStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(path = "/")
@SessionAttributes(value = "userSession")
public class AuthorithationController {


    @Qualifier("userInMemory")
    @Autowired
    UserStorage userStorage;


    @Qualifier("historyInMemory")
    @Autowired
    HistoryStorage historyStorage;


    @GetMapping(path = "/reg")
    public ModelAndView registView(ModelAndView modelAndView) {
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @PostMapping(path = "/regist")
    public ModelAndView regist(@Valid User user, BindingResult result, ModelAndView modelAndView)  {

        if (result.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();
            for (FieldError fieldError : result.getFieldErrors()) {
                errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            modelAndView.addObject("errors", errorMap);
            modelAndView.addObject("user", user);
            modelAndView.setViewName("registration");
            System.out.println(errorMap);
        } else {
            if (!userStorage.userInMemori(user)) {
                userStorage.addInMemory(user);
                modelAndView.setViewName("index");
            } else {
                throw new NoSuchUserExeption("Such a user already exists");
            }
        }
        return modelAndView;
    }

    /**
     * Registration
     **/
    @GetMapping(path = "/auth")
    public ModelAndView authorView(ModelAndView modelAndView) {
        modelAndView.setViewName("authorithation");
        return modelAndView;
    }

    @PostMapping(path = "/authoriz")
    public ModelAndView authorith(@Valid @ModelAttribute("user") UserModel user, BindingResult result, ModelAndView modelAndView)  {
        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError fieldError : result.getFieldErrors()) {
                errors.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            modelAndView.addObject("err", errors);
            modelAndView.setViewName("authorithation");
            System.out.println(errors);
        } else {
            User user1 = new User(user.getLogin(), user.getPassword());
            if (userStorage.checkLoginAndPassword(user1)) {
                modelAndView.setViewName("index");
                modelAndView.addObject("userSession", userStorage.getByLogin(user.getLogin()));
                System.out.println("good");
            } else {
                System.out.println("bad");
                throw new NoSuchUserExeption("There is no such user please register.");
            }
        }

        return modelAndView;
    }
}
