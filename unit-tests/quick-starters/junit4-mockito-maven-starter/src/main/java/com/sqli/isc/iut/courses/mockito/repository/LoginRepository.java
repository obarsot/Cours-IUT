package com.sqli.isc.iut.courses.mockito.repository;

import static org.slf4j.LoggerFactory.getLogger;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;

import com.sqli.isc.iut.courses.mockito.model.UserForm;

public class LoginRepository {

	private static final Logger LOGGER = getLogger(LoginRepository.class);

	Map<String, String> users;

	public LoginRepository() {
		// Users of the system are stored in this map (key=username, value=password)
		users = new HashMap<>();
		users.put("user1", "p1");
		users.put("user2", "p3");
		users.put("user3", "p4");
	}

	public boolean login(UserForm userForm) {
		LOGGER.debug("LoginRepository.login {}", userForm);

		String username = userForm.getUsername();
		String password = userForm.getPassword();

		return users.keySet().contains(username) && users.get(username).equals(password);
	}

}
