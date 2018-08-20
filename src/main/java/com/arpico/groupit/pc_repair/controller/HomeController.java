package com.arpico.groupit.pc_repair.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@PropertySource("classpath:application.properties")
public class HomeController {
	
	@Value("${server.context-path}")
	private String path;
	
	@Autowired
	ServletContext context;
	
	@RequestMapping("/")
	public ModelAndView welcome() {
		System.out.println(path);
		context.setAttribute("path", path);
		
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("title", "PC REPAIR | HOME");
		return mav;
	}
	
}
