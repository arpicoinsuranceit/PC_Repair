package com.arpico.groupit.pc_repair.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ContextController {

	@Autowired
	ServletContext context;

	public void setContextName() {
		context.setAttribute("path", "/PCRepair");
	}

}
