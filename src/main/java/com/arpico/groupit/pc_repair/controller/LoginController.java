package com.arpico.groupit.pc_repair.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@PropertySource("classpath:application.properties")
public class LoginController {

	@Value("${server.context-path}")
	private String path;

	@Autowired
	private HttpSession httpSession;

	@Autowired
	ServletContext context;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		context.setAttribute("path", path);

		ModelAndView mav = new ModelAndView("login");

		mav.addObject("title", "PC REPAIR | LOGIN");
		return mav;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam(value = "userName") String userName,
			@RequestParam(value = "password") String password) {

		return "home";
	}

}
