package com.ssc.bkb.exception;

public class BasketballNotFoundException extends RuntimeException {

	public BasketballNotFoundException(Long id) {
		super("Could not find user " + id);
	}
}
