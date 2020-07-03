package com.ssc.bkb.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UserInfoNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(UserInfoNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String employeeNotFoundHandler(UserInfoNotFoundException ex) {
        return ex.getMessage();
    }
}
