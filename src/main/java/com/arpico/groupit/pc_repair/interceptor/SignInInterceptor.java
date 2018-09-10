package com.arpico.groupit.pc_repair.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class SignInInterceptor implements HandlerInterceptor {

	@Autowired
	private HttpSession httpSession;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		if (!request.getRequestURI().equals("/PCRepair/login")) {

			Object user = httpSession.getAttribute("user");
			if (null == user) {
				response.sendRedirect("login");
			}
		}

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		Object user = httpSession.getAttribute("user");
		if (null != user) {
			request.setAttribute("user_name", "abcd");

		}

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
