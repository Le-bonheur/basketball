package com.ssc.bkb.payroll;

class OrderNotFoundException extends RuntimeException {

	OrderNotFoundException(Long id) {
		super("Could not find order " + id);
	}
}
