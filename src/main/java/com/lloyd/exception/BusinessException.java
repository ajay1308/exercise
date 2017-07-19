package com.lloyd.exception;

/**
 * The Class BusinessException.
 * 
 * @author Ajay
 */
public class BusinessException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1313505581362514299L;
	
	/** The code. */
	private String code;
	
	/**
	 * Instantiates a new business exception.
	 */
	public BusinessException(){
		
	}
	
	/**
	 * Instantiates a new business exception.
	 *
	 * @param code the code
	 * @param message the message
	 */
	public BusinessException(final String code, final String message) {
		super(message);
		this.code = code;
	}

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public String getCode() {
		return this.code;
	}
	
	/**
	 * Sets the code.
	 *
	 * @param code the code to set
	 */
	public void setCode(final String code) {
		this.code = code;
	}

	
}
