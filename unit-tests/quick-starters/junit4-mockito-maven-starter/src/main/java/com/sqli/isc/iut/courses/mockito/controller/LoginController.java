package com.sqli.isc.iut.courses.mockito.controller;

import static org.slf4j.LoggerFactory.getLogger;

import org.slf4j.Logger;

import com.sqli.isc.iut.courses.mockito.model.UserForm;
import com.sqli.isc.iut.courses.mockito.service.LoginService;

public class LoginController {

	private static final Logger LOGGER = getLogger(LoginController.class);

	private LoginService loginService;

	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}

	public String login(UserForm userForm) {
		LOGGER.debug("LoginController.login {}", userForm);

		try {
			if (userForm == null) {
				return "ERROR";
			} else if (loginService.login(userForm)) {
				return "OK";
			} else {
				return "KO";
			}
		} catch (Exception e) {
			return "ERROR";
		}
	}

	public void logout(UserForm userForm) {
		LOGGER.debug("LoginController.logout {}", userForm);

		loginService.logout(userForm);
	}

}
