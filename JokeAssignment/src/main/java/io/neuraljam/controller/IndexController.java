package io.neuraljam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import io.neuraljam.entities.Joke;

@Controller
public class IndexController {

@RequestMapping(value = {"/home"}, method=RequestMethod.GET)
   public ModelAndView homepage() {
       ModelAndView model = new ModelAndView();

       model.setViewName("home");
       return model;
   }

@RequestMapping(value = {"/"}, method=RequestMethod.GET)
public ModelAndView home() {
    ModelAndView model = new ModelAndView();

    model.setViewName("home");
    return model;

}
}
	

	
	
	  
	

