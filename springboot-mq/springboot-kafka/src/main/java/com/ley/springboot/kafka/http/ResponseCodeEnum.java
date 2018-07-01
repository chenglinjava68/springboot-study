package com.ley.springboot.kafka.http;

public enum ResponseCodeEnum {
	
	/**
	 * 响应成功
	 * **/
	SUCCESS("r0001"),
	
	/**
	 * 响应失败
	 * **/
	ERROR("r0000"),
	
	/**
	 * 响应异常
	 * **/
	EXCEPTION("r0003")
	;
	
	private ResponseCodeEnum(String code){
		this.code=code;
	}

	private String code;

	public String getCode() {
		return code;
	}
}
