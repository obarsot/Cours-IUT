package com.sqli.isc.iut.courses.mockito.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.sqli.isc.iut.courses.mockito.exception.LoginException;
import com.sqli.isc.iut.courses.mockito.model.UserForm;
import com.sqli.isc.iut.courses.mockito.repository.LoginRepository;

public class LoginServiceTest {

	@InjectMocks
	private LoginService loginService;

	@Mock
	private LoginRepository loginRepository;

	private AutoCloseable closeable;

	private UserForm userForm = new UserForm("foo", "bar");

	@Before
	public void setUp() {
		closeable = MockitoAnnotations.openMocks(this);
	}

	@After
	public void tearDown() throws Exception {
		closeable.close();
	}

	@Test
	public void should_return_true_when_correct_login() {
		when(loginRepository.login(any(UserForm.class))).thenReturn(true);

		assertTrue(loginService.login(userForm));

		verify(loginRepository, atLeast(1)).login(userForm);
		verifyNoMoreInteractions(loginRepository);
	}

	@Test
	public void should_return_false_when_incorrect_login() {
		when(loginRepository.login(any(UserForm.class))).thenReturn(false);

		assertFalse(loginService.login(userForm));

		verify(loginRepository, times(1)).login(userForm);
		verifyNoMoreInteractions(loginRepository);
	}

	@Test(expected = LoginException.class)
	public void should_throw_exception_when_login_twice() {
		when(loginRepository.login(userForm)).thenReturn(true);

		loginService.login(userForm);
		loginService.login(userForm);
	}

}