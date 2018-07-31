package com.arpico.groupit.pc_repair.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public ModelAndView welcome() {

		ModelAndView mav = new ModelAndView("index");
		mav.addObject("title", "PC REPAIR | HOME");
		return mav;
	}
	
}
