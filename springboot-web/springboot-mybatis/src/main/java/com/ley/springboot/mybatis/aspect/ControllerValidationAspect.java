package com.ley.springboot.mybatis.aspect;



import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import com.ley.springboot.mybatis.http.BindingResultUtils;

@Aspect
@Component
public class ControllerValidationAspect {

	private static final Logger logger = LoggerFactory.getLogger(ControllerValidationAspect.class);

	/**
	 * 切面注解表达式
	 **/
	private static final String CONTROLLER_VALIDATION_POINTCUT = "execution(* com.ley.springboot.mybatis.controller.*.*(..))"
			+ " && @annotation(com.ley.springboot.mybatis.annotation.NeedValidation))";

	@Pointcut(value = CONTROLLER_VALIDATION_POINTCUT)
	protected void pointCut() {

	}

	/**
	 * 保证要验证的对象是在第一个参数而且必须要有{@link Validated}验证注解
	 * 
	 * @throws Throwable
	 **/
	@Around(value = "pointCut()")
	public Object processAround(ProceedingJoinPoint joinPoint) throws Throwable {
		logger.info("进入" + joinPoint.getSignature() + "方法");
		Object[] args = joinPoint.getArgs();
		if (args != null && args.length > 0) {
			Object validatedTarget = args[0];// 获取需要验证的对象
			for (Object var : args) {
				if (var instanceof BindingResult) {
					BindingResult errors = (BindingResult) var;
					if (errors.hasErrors()) {
						logger.info("出" + joinPoint.getSignature() + "方法");
						return BindingResultUtils.bindingResult(errors, validatedTarget.getClass().getName());
					} else {
						// 一旦调用ProceedingJoinPoint#proceed(),则方法返回;不调用方法不执行
						logger.info("出" + joinPoint.getSignature() + "方法");
						return joinPoint.proceed();
					}
				}
			}
		}
		return null;
	}
}
