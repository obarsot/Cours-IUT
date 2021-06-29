package com.sqli.isc.iut.courses.junit;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

class HamcrestTest {

	@Test
	void this_is_my_first_test_with_hamcrest_matchers() {
		assertThat(2 + 1, equalTo(3));
		assertThat("Foo", notNullValue());
		assertThat("Hello world", containsString("world"));
	}

}
