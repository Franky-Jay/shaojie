package com.mashen.privilege.exception;

public class DataAccessDeniedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8428246110927490617L;

	public DataAccessDeniedException() {
	}

	public DataAccessDeniedException(String message) {
		super(message);
	}

	public DataAccessDeniedException(Throwable cause) {
		super(cause);
	}

	public DataAccessDeniedException(String message, Throwable cause) {
		super(message, cause);
	}

	public DataAccessDeniedException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
