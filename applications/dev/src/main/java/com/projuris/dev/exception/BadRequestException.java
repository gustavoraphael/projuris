package com.projuris.dev.exception;

/**
 * Excessão customizada para BadRequest.
 *
 * @author Gustavo Raphael Laurindo Pereira
 */
public class BadRequestException extends BaseException {

	private static final String title = "Bad Request";

	private static final Integer status = 400;

	public BadRequestException(String message) {
		this(title, message);
	}

	public BadRequestException(String title, String message) {
		super(title, status, message);
	}

}
