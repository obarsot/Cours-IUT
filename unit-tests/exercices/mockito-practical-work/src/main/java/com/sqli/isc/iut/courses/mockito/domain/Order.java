package com.sqli.isc.iut.courses.mockito.domain;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Order {

	private List<Product> products;

	public Order(List<Product> products) {
		this.products = products != null ? products : new ArrayList<>();
	}

	public BigDecimal getTotalPrice() {
		BigDecimal total = BigDecimal.ZERO;

		for (Product product : products) {
			total = total.add(product.getPrice());
		}

		return total;
	}

	public String formatTotalPrice(Locale locale) {
		try {
			return NumberFormat.getCurrencyInstance(locale).format(getTotalPrice());
		} catch (IllegalArgumentException iae) {
			return "";
		}
	}

}
