package com.mashen.privilege.exception;

public class FunctionAccessDeniedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8428246110927490617L;

	public FunctionAccessDeniedException() {
	}

	public FunctionAccessDeniedException(String message) {
		super(message);
	}

	public FunctionAccessDeniedException(Throwable cause) {
		super(cause);
	}

	public FunctionAccessDeniedException(String message, Throwable cause) {
		super(message, cause);
	}

	public FunctionAccessDeniedException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
