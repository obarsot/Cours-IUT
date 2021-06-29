package com.sqli.isc.iut.courses.junit;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.slf4j.LoggerFactory.getLogger;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

class HelloWorldTest {

	private static final Logger LOGGER = getLogger(HelloWorldTest.class);

	@Test
	@DisplayName("😱")
	void this_is_my_first_test_with_emoji() {
		LOGGER.debug("** This is my first test with JUnit 5 ***");

		assertTrue(true);
	}

}
