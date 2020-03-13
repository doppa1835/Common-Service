package com.erp.commonservice.util.exception;

public class ERPException extends RuntimeException {

	/**
	 * 
	 * 
	 */

	private static final long serialVersionUID = 1L;

	private int code;

	private String message;

	private String detailMessage;

	public ERPException(int code, String message, String detailMessage) {
		this.code = code;
		this.message = message;
		this.detailMessage = detailMessage;
	}

	public ERPException(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetailMessage() {
		return detailMessage;
	}

	public void setDetailMessage(String detailMessage) {
		this.detailMessage = detailMessage;
	}

}
