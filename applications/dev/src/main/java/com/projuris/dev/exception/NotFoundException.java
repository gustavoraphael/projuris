package com.projuris.dev.exception;

/**
 * Excessão customizada para NotFound.
 *
 * @author Gustavo Raphael Laurindo Pereira
 */

public class NotFoundException extends BaseException {

	private static final String title = "Not Found";

	private static final Integer status = 404;

	public NotFoundException(String title, String message) {
		super(title, status, message);
	}

	public NotFoundException(String message) {
		this(title, message);
	}

}
