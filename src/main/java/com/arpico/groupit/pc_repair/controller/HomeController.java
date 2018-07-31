package com.arpico.groupit.pc_repair.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String welcome() {
		return "index";
	}
	
}
