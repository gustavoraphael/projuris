package com.projuris.dev.exception;

public class BaseException extends RuntimeException {

	private String title;

	private Integer status;

	public BaseException(String title, Integer status, String message) {
		super(message);

		this.title = title;
		this.status = status;
	}

	public BaseException(String message) {
		super(message);
	}

	public BaseException(String message, Throwable cause) {
		super(message, cause);
	}

	public String getTitle() {
		return title;
	}

	public Integer getStatus() {
		return status;
	}
}
