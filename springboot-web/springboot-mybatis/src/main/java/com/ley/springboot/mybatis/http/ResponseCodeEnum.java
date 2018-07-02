package com.ley.springboot.mybatis.http;

public enum ResponseCodeEnum {
	
	/**
	 * 响应成功
	 * **/
	SUCCESS("r001"),
	
	/**
	 * 响应失败
	 * **/
	ERROR("r002"),
	
	/**
	 * 响应异常
	 * **/
	EXCEPTION("r004"),
	
	/**
	 * 数据找不到
	 * **/
	NO_DATA("r005"),
	
	/**
	 * 更新数据不成功
	 * **/
	UPDATE_UNSUCCESS("r006")
	;
	
	private ResponseCodeEnum(String code){
		this.code=code;
	}

	private String code;

	public String getCode() {
		return code;
	}
}
