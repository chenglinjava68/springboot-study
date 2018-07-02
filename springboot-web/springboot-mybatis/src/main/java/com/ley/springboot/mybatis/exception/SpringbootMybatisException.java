package com.ley.springboot.mybatis.exception;

import com.ley.springboot.mybatis.http.ResponseCodeEnum;

public class SpringbootMybatisException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 错误码
	 **/
	private String errorCode;

	public SpringbootMybatisException(String message) {
		this(ResponseCodeEnum.ERROR.getCode(), message);
	}

	public SpringbootMybatisException(String errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}
}
