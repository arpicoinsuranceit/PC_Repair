package com.arpico.groupit.pc_repair.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.arpico.groupit.pc_repair.service.RepairService;

@Controller
@PropertySource("classpath:application.properties")
public class HomeController {
	
	@Autowired
	private RepairService repairService;
	
	@Value("${server.context-path}")
	private String path;
	
	@Autowired
	ServletContext context;
	
	@RequestMapping("/")
	public ModelAndView welcome() throws Exception {
		context.setAttribute("path", path);
		
		
		Map<String, Integer> values = repairService.getHomeValues();
		
		ModelAndView mav = new ModelAndView("index");
		
		mav.addObject("title", "PC REPAIR | HOME");
		mav.addObject("values", values);
		
		return mav;
	}
	
}
