package com.jsp.signup.aop;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.jsp.signup.exceptions.InvalidEmailException;
import com.jsp.signup.exceptions.InvalidPasswordException;

@Component
@Aspect
public class SignUpAspect {

	@Before("execution(* saveUser(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)) && args(req, resp)")
	public void signUpValidator(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		String userPassword = req.getParameter("userPassword");
		String userConfirmPassword = req.getParameter("confirmPassword");
		String userEmail = req.getParameter("userEmail");

		req.setAttribute("validation", true);

		try {
			if (!userPassword.equals(userConfirmPassword)) {
				req.setAttribute("validation", false);
				throw new InvalidPasswordException("Password mismatched");
			} else if ((userEmail.endsWith("gmail.com") || userEmail.endsWith("yahoo.com")
					|| userEmail.endsWith("rediff.com")) == false) {
				req.setAttribute("validation", false);
				throw new InvalidEmailException("Incorrect Email!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("message", "<h1>" + e.getMessage() + "</h1>");
		}
	}
}
