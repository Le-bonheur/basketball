package com.ssc.bkb.exception;

public class UserInfoNotFoundException extends RuntimeException {

	public UserInfoNotFoundException(int id) {
		super("Could not find user " + id);
	}
}
