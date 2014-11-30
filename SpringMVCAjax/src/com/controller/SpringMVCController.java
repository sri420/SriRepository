package com.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class SpringMVCController {

	@RequestMapping(value = "/helloWorld.web", method = 
			RequestMethod.GET)
	public String printWelcome(@ModelAttribute("person") 
	Person person,BindingResult result, ModelMap model, 
	HttpServletRequest request,
			HttpServletResponse response) {

		model.addAttribute("message", "AJAX JQuery example");
		return "helloWorld";

	}

	@RequestMapping(value = "/validateCaptchaThroughAJAX.web", 
			method = RequestMethod.POST)
	@ResponseBody
	public String validateCaptchaThroughAJAX(@RequestBody 
			String json)
			throws IOException {

		ObjectMapper mapper = new ObjectMapper();
		Person requesValue = mapper.readValue(json, 
				Person.class);
		Person person = new Person();
		person.setName(requesValue.getName());
		person.setLocation(requesValue.getLocation());

		String viewName = "Success";
		if (viewName.equalsIgnoreCase("Success")) {
			person.setValidation("Success");
		} else {
			person.setValidation("Error");
		}

		return toJson(person);
	}

	private String toJson(Person person) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			String value = mapper.writeValueAsString(person);
			// return "["+value+"]";
			return value;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}
	}

}