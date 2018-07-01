package com.ley.springboot.kafka.http;

public class Response {

	private String reponseCode;
	
	private String message;
	
	private Object data;
	
	

	public Response(String reponseCode, String message, Object data) {
		super();
		this.reponseCode = reponseCode;
		this.message = message;
		this.data = data;
	}
	
	

	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getReponseCode() {
		return reponseCode;
	}

	public void setReponseCode(String reponseCode) {
		this.reponseCode = reponseCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Response [reponseCode=" + reponseCode + ", message=" + message + ", data=" + data + "]";
	}
}
