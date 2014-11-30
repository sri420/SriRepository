package com.javahonk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SpringMVCController {
	
	@RequestMapping(value="/helloWorld.web",method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

		model.addAttribute("message", "Hello World!!!");
		return "helloWorld";

	}
	
	//test
	@RequestMapping(value="/springMVCReturnJSON.web", 
			method=RequestMethod.GET,
			produces={"application/json"})
    public @ResponseBody Person  getPerson() {		
		Person person = new Person();
		person.setFirstName("Java");
		person.setLastName("Honk");
		return person;
	}
}