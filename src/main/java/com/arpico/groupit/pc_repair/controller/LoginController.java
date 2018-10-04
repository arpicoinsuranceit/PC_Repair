package com.arpico.groupit.pc_repair.controller;

import java.util.Map;

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

import com.arpico.groupit.pc_repair.dto.LoginResponseDto;
import com.arpico.groupit.pc_repair.service.LoginService;
import com.arpico.groupit.pc_repair.service.RepairService;

@Controller
@PropertySource("classpath:application.properties")
public class LoginController {

	@Value("${server.context-path}")
	private String path;

	@Autowired
	private HttpSession httpSession;

	@Autowired
	private RepairService repairService;

	@Autowired
	private LoginService loginService;

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
	public ModelAndView login(@RequestParam(value = "userName") String userName,
			@RequestParam(value = "password") String password) throws Exception {

		LoginResponseDto loginResponseDto = loginService.login(userName, password);

		if (loginResponseDto.isLogin() == true) {
			httpSession.setAttribute("user", loginResponseDto);

			context.setAttribute("path", path);

			Map<String, Integer> values = repairService.getHomeValues();

			ModelAndView mav = new ModelAndView("index");

			mav.addObject("title", "PC REPAIR | HOME");
			mav.addObject("values", values);

			return mav;
		} else {
			ModelAndView mav = login();

			mav.addObject("login_error", "Username or password incorrect");
			return mav;
		}

	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		context.setAttribute("path", path);
		httpSession.invalidate();
		return "login";
	}


}
