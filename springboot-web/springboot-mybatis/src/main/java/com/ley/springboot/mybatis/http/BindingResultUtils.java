package com.ley.springboot.mybatis.http;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

public class BindingResultUtils {

    private static final Logger logger = LoggerFactory.getLogger(BindingResultUtils.class);

    /**
     * Handles entity class fields errors and this method use for example<b>(处理实体类实体域错误和使用方法如下):看@see
     * and commons annotations(常用注解).</b><br>
     * <b>For example(例如):见链接:https://www.cnblogs.com/atai/p/6943404.html</b>
     * @param errors    binding result errors
     * @param className the error object class name
     **/
    public static Response bindingResult(BindingResult errors, String className) {
        List<ObjectError> fieldErrors = errors.getAllErrors();
        List<ResultError> resultErrors = new ArrayList<>();
        for (ObjectError error : fieldErrors) {
            ResultError resultError = new ResultError(className, error.getObjectName(), ((FieldError) error).getField(), error.getDefaultMessage());
            resultErrors.add(resultError);
            logger.error("error class name = {},error object = {},error filed = {},error message = {}", className, error.getObjectName(), ((FieldError) error).getField(), error.getDefaultMessage());
        }
        return new Response(ResponseCodeEnum.UPDATE_UNSUCCESS.getCode(),"更新数据或者插入数据不成功(后台数据校验不通过)",resultErrors);
    }
}
