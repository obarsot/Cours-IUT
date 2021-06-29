package com.sqli.isc.iut.courses.mockito.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sqli.isc.iut.courses.mockito.model.UserForm;
import com.sqli.isc.iut.courses.mockito.service.LoginService;

@ExtendWith(MockitoExtension.class)
class LoginControllerLoginTest {

	@InjectMocks
	private LoginController loginController;

	@Mock
	private LoginService loginService;

	private UserForm userForm = new UserForm("foo", "bar");

	@Test
	void should_return_ok_when_correct_login() {
		// Given
		when(loginService.login(userForm)).thenReturn(true);

		// When
		String reseponseLogin = loginController.login(userForm);

		// Then
		assertEquals("OK", reseponseLogin);
		verify(loginService).login(userForm);
		verifyNoMoreInteractions(loginService);
	}

	@Test
	void should_return_ko_when_incorrect_login() {
		// Given
		when(loginService.login(userForm)).thenReturn(false);

		// When
		String reseponseLogin = loginController.login(userForm);

		// Then
		assertEquals("KO", reseponseLogin);
		verify(loginService).login(userForm);
	}

	@Test
	void should_return_error_when_no_login_provided() {
		// Given/When
		String response = loginController.login(null);

		// Then
		assertEquals("ERROR", response);
	}

	@Test
	void testLoginException() {
		// Given/When
		when(loginService.login(userForm)).thenThrow(IllegalArgumentException.class);
		String response = loginController.login(userForm);

		// Then
		assertEquals("ERROR", response);
	}

	@Test
	public void should_logout() {
		loginController.logout(userForm);

		verify(loginService).logout(userForm);
		verifyNoMoreInteractions(loginService);
	}

}