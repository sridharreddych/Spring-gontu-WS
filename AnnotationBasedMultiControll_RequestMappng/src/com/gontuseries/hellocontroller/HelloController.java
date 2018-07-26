package com.gontuseries.hellocontroller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/greet")
public class HelloController {

	@RequestMapping("/welcome")
	public ModelAndView helloWorld() {

		ModelAndView model = new ModelAndView("HelloPage");
		model.addObject("msg","hello world using Annotation");

		return model;
	}

	@RequestMapping("/hi")
	public ModelAndView hiWorld() {

		ModelAndView model = new ModelAndView("HelloPage");
		model.addObject("msg","hello world using hi mapping Annotation");

		return model;
	}
	
}