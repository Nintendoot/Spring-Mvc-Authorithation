package by.nintendo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.xml.ws.spi.http.HttpHandler;

@Controller
@RequestMapping(path = "/")
public class HomeController {

	@GetMapping(path = "/home")
	public ModelAndView index(HttpSession session,ModelAndView modelAndView){

	      modelAndView.setViewName("index");
	      if(session.getAttribute("session")==null){
	      	return modelAndView;
		  }else{
			  modelAndView.addObject(session.getAttribute("session"));
		  }

		return modelAndView;
	}
}
