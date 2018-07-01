package com.ley.springboot.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import com.ley.springboot.kafka.http.Response;
import com.ley.springboot.kafka.http.ResponseCodeEnum;
import com.ley.springboot.kafka.message.Message;

import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/kafka")
public class MessageController {
	
	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;

	@RequestMapping(value = "/send", method = RequestMethod.GET)
	public Response sendKafka(HttpServletRequest request, HttpServletResponse response) {
		try {
			Message message = new Message();
			message.setMessage("我是kafka发送者");
			message.setSendDate(new Date(System.currentTimeMillis()));
			message.setMessageId(UUID.randomUUID().toString());
			kafkaTemplate.send("test", message.toString());
			return new Response(ResponseCodeEnum.SUCCESS.getCode(), "发送kafka成功", message);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response(ResponseCodeEnum.EXCEPTION.getCode(), "发送kafka失败", null);
		}
	}

}