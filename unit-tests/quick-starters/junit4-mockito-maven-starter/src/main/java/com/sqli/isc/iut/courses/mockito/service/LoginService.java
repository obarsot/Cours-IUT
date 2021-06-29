package com.sqli.isc.iut.courses.mockito.service;

import static org.slf4j.LoggerFactory.getLogger;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;

import com.sqli.isc.iut.courses.mockito.exception.LoginException;
import com.sqli.isc.iut.courses.mockito.model.UserForm;
import com.sqli.isc.iut.courses.mockito.repository.LoginRepository;

public class LoginService {

	private static final Logger LOGGER = getLogger(LoginService.class);

	private LoginRepository loginRepository;
	private List<String> usersLogged = new ArrayList<>();

	public LoginService(LoginRepository loginRepository) {
		this.loginRepository = loginRepository;
	}

	public boolean login(UserForm userForm) {
		LOGGER.debug("LoginService.login {}", userForm);

		// Preconditions
		checkForm(userForm);

		// Same user cannot be logged twice
		String username = userForm.getUsername();

		if (usersLogged.contains(username)) {
			throw new LoginException(username + " already logged");
		}

		// Call to repository to make logic
		boolean login = loginRepository.login(userForm);

		if (login) {
			usersLogged.add(username);
		}

		return login;
	}

	public void logout(UserForm userForm) {
		LOGGER.debug("LoginService.logout {}", userForm);

		// Preconditions
		checkForm(userForm);

		String username = userForm.getUsername();

		if (!usersLogged.contains(username)) {
			throw new LoginException(username + " not logged");
		}

		usersLogged.remove(username);
	}

	public int getUserLoggedCount() {
		return usersLogged.size();
	}

	private void checkForm(UserForm userForm) {
		assert userForm != null;
		assert userForm.getUsername() != null;
		assert userForm.getPassword() != null;
	}

}