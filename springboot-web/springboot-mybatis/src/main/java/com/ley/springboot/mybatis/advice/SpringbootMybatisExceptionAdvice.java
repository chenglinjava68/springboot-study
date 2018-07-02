package com.ley.springboot.mybatis.advice;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import com.ley.springboot.mybatis.exception.SpringbootMybatisException;
import com.ley.springboot.mybatis.http.Response;
import com.ley.springboot.mybatis.http.ResponseCodeEnum;


@ControllerAdvice
public class SpringbootMybatisExceptionAdvice {

	private static final Logger logger=LoggerFactory.getLogger(SpringbootMybatisExceptionAdvice.class);

	
	/**
	 * 受检异常
	 * **/
    @ExceptionHandler(SpringbootMybatisException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Response handlerSpringbootMybatisException(HttpServletRequest request,SpringbootMybatisException exception) {
    	//缺少日志打印,很重要
    	logger.warn(exception.getMessage(), exception);
    	return new Response(exception.getErrorCode(), exception.getMessage(),new String("url:"+request.getRequestURL().toString()));
    }

    /**
     * 非受检异常
     * **/
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Response handlerSpringbootMybatisException(HttpServletRequest request,Exception exception) {
        // TODO 在数据库中记录程序异常，这个地方的异常是未处理的异常，需要管理员查看并进行处理以防重复出现
    	logger.error(exception.getMessage(), exception);
    	return new Response(ResponseCodeEnum.ERROR.getCode(), "程序异常,请重试.如果重复出现请联系管理员处!",new String("url:"+request.getRequestURL().toString()));
    }
}
