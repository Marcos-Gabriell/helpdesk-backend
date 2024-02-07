package br.com.helpdesk.services.exceptions;

public class DataIntegerityViolationException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DataIntegerityViolationException(String message, Throwable cause) {
		super(message, cause);
	}

	public DataIntegerityViolationException(String message) {
		super(message);
	}

}
