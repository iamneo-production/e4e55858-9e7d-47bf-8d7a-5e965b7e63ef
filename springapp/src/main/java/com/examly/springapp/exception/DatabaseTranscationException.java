package com.example.springbootproject.exception;

public class DatabaseTranscationException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public DatabaseTranscationException(String message) {
		super(message);
	}

}