package com.ssc.bkb.exception;

public class UserInfoNotFoundException extends RuntimeException {

	public UserInfoNotFoundException(Long id) {
		super("Could not find user " + id);
	}
}
