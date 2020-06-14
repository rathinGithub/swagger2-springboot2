package com.techwithratz.initialzr.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BabyNotFoundException extends RuntimeException {

	public BabyNotFoundException(String message) {
		super(message);
	}
}
