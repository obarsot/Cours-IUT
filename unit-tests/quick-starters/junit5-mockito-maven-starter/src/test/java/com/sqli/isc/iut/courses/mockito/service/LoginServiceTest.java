package com.sqli.isc.iut.courses.mockito.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.sqli.isc.iut.courses.mockito.exception.LoginException;
import com.sqli.isc.iut.courses.mockito.model.UserForm;
import com.sqli.isc.iut.courses.mockito.repository.LoginRepository;

class LoginServiceTest {

	@InjectMocks
	LoginService loginService;

	@Mock
	LoginRepository loginRepository;

	UserForm userForm = new UserForm("foo", "bar");

	private AutoCloseable closeable;

	@BeforeEach
	public void setUp() {
		closeable = MockitoAnnotations.openMocks(this);
	}

	@AfterEach
	public void tearDown() throws Exception {
		closeable.close();
	}

	@Test
	void testLoginOk() {
		when(loginRepository.login(any(UserForm.class))).thenReturn(true);
		assertTrue(loginService.login(userForm));
		verify(loginRepository, atLeast(1)).login(userForm);
	}

	@Test
	void testLoginKo() {
		when(loginRepository.login(any(UserForm.class))).thenReturn(false);
		assertFalse(loginService.login(userForm));
		verify(loginRepository, times(1)).login(userForm);
	}

	@Test
	void testLoginTwice() {
		when(loginRepository.login(userForm)).thenReturn(true);
		assertThrows(LoginException.class, () -> {
			loginService.login(userForm);
			loginService.login(userForm);
		});
	}

}