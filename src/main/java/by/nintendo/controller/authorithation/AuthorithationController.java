package by.nintendo.controller.authorithation;

import by.nintendo.entity.User;
import by.nintendo.storage.user.UserStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(path = "/")
@SessionAttributes(value = "userSession")
public class AuthorithationController {

    @Autowired
    @Qualifier("userInMemory")
    UserStorage userStorage;


    /**
     * Authorithation
     **/
    @GetMapping(path = "/author")
    public ModelAndView authorithView(ModelAndView modelAndView) {
        modelAndView.setViewName("authorithation");
        return modelAndView;
    }

    @PostMapping(path = "/auth")
    public ModelAndView authorithation(@Valid User user, BindingResult result, ModelAndView modelAndView) {

        if (result.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();
            for(FieldError fieldError:result.getFieldErrors()){
           errorMap.put(fieldError.getField(),fieldError.getDefaultMessage());
            }
            modelAndView.addObject("errors", errorMap);
            modelAndView.setViewName("authorithation");
            System.out.println(errorMap);
        } else {
            if (userStorage.userInMemori(user)) {
                System.out.println("uze est");
                modelAndView.setViewName("history");
            } else {
                userStorage.addInMemory(user);
                modelAndView.setViewName("index");
            }
        }


        return modelAndView;
    }


    /**
     * Registration
     **/

    @GetMapping(path = "/registrat")
    public ModelAndView registrationView(ModelAndView modelAndView) {
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @PostMapping(path = "/regist")
    public ModelAndView registration(@Valid @ModelAttribute("user") User user, BindingResult result, ModelAndView modelAndView) {
        if (result.hasErrors()) {
            Map<String, String> error = new HashMap<>();
            for (FieldError errordsd : result.getFieldErrors()) {
                error.put(errordsd.getField(), errordsd.getDefaultMessage());
            }
            modelAndView.addObject("err", error);
            modelAndView.setViewName("registration");
            System.out.println(error);
        } else {
            if (userStorage.checkLoginAndPassword(user)) {
                modelAndView.setViewName("index");
                modelAndView.addObject("userSession", userStorage.getByLogin(user.getLogin()));

            } else {
                modelAndView.setViewName("index");
            }
        }

        return modelAndView;
    }

//    @InitBinder("Auth")
//    private void initUserBinder(WebDataBinder authBinder ) {
//        authBinder.setValidator(new User());
//    }
}
