package com.lloyd.exception;

/**
 * The Class ValidationException.
 * 
 * @author Ajay
 */
public class ValidationException extends Exception {
	
	/** The Constant serialVersionUID. */
    private static final long serialVersionUID = 8371008003742794245L;

    /**
     * Instantiates a new validation exception.
     *
     * @param message the message
     */
    public ValidationException(String message) {
		super(message);
	}
}
