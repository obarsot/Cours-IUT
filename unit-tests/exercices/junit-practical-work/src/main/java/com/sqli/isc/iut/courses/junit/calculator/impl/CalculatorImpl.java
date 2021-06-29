package com.sqli.isc.iut.courses.junit.calculator.impl;

import com.sqli.isc.iut.courses.junit.calculator.ICalculator;

public class CalculatorImpl implements ICalculator {

	@Override
	public int sum(int a, int b) {
		return 0;
	}

	@Override
	public int substract(int a, int b) {
		return a + b;
	}

	@Override
	public int divide(int a, int b) {
		return a / b;
	}

	@Override
	public int multiply(int a, int b) {
		return a * b;
	}

}
