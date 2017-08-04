package com.smartxp.commons.email;

public class EmailException extends Exception{
	
	/**
	 * 自定义邮件异常
	 */
	private static final long serialVersionUID = 8161748742229905144L;

	public EmailException() {
		super();
	}
	
	public EmailException(String error) {
		super(error);
	}
}
