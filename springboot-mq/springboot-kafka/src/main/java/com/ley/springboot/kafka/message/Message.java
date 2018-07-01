package com.ley.springboot.kafka.message;


import java.util.Date;


import com.fasterxml.jackson.annotation.JsonFormat;

public class Message {

	private String message;
	
	private String messageId;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date sendDate;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

	@Override
	public String toString() {
		return "Message [message=" + message + ", messageId=" + messageId + ", sendDate=" + sendDate + "]";
	}
	
	
}
