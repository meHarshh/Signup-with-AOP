package com.jsp.signup.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.signup.model.SignUp;
import com.jsp.signup.service.SignUpService;

@Controller
public class SignUpController {
	@Autowired
	private SignUpService signUpService;

	@RequestMapping("/saveUser")
	public ModelAndView saveUser(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("addMessage.jsp");
		boolean validation = (boolean) req.getAttribute("validation");
		System.out.println(validation);
		if (validation) {
			int userId = Integer.parseInt(req.getParameter("userId"));
			String userName = req.getParameter("userName");
			String userPassword = req.getParameter("userPassword");
			String userEmail = req.getParameter("userEmail");

			SignUp signup = new SignUp();
			signup.setUserId(userId);
			signup.setUserName(userName);
			signup.setUserPassword(userPassword);
			signup.setUserEmail(userEmail);

			signUpService.saveUser(signup);

			modelAndView.addObject("addUsers", "<h1>User Signed in Successfully</h1>");
		} else {
			modelAndView.addObject("addUsers", req.getAttribute("message"));
		}
		return modelAndView;
	}
}
