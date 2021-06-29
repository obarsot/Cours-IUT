package com.sqli.isc.iut.courses.mockito.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.sqli.isc.iut.courses.mockito.model.UserForm;
import com.sqli.isc.iut.courses.mockito.service.LoginService;

@RunWith(MockitoJUnitRunner.class)
public class LoginControllerTest {

	@InjectMocks
	private LoginController loginController;

	@Mock
	private LoginService loginService;

	private UserForm userForm = new UserForm("foo", "bar");

	@Test
	public void should_login() {
		loginController.login(userForm);
		verify(loginService).login(userForm);
		verifyNoMoreInteractions(loginService);
	}

	@Test
	public void should_return_ok_when_correct_login() {
		when(loginService.login(userForm)).thenReturn(true);
		assertEquals("OK", loginController.login(userForm));

		verify(loginService).login(userForm);
		verifyNoMoreInteractions(loginService);
	}

	@Test
	public void should_return_ko_when_incorrect_login() {
		when(loginService.login(userForm)).thenReturn(false);
		assertEquals("KO", loginController.login(userForm));
	}

	@Test
	public void should_return_error_when_no_login_provided() {
		assertEquals("ERROR", loginController.login(null));
	}

	@Test
	public void should_return_error_when_exception_occured() {
		when(loginService.login(userForm)).thenThrow(IllegalArgumentException.class);
		assertEquals("ERROR", loginController.login(userForm));
	}

	@Test
	public void should_logout() {
		loginController.logout(userForm);

		verify(loginService).logout(userForm);
		verifyNoMoreInteractions(loginService);
	}

}