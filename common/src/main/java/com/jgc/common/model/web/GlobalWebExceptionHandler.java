package com.jgc.common.model.web;

import com.jgc.common.exception.AbstractBusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Iterator;

/**
 * <p>全局异常处理</p>
 *
 * @author HuMingAn
 * @version 1.0
 * @date 2021/02/18 13:56
 **/
@ControllerAdvice
public class GlobalWebExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalWebExceptionHandler.class);

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseBody
    public RestfulResponseBody<Object> parameterCheckError(MethodArgumentNotValidException e){
        BindingResult bindingResult = e.getBindingResult();
        Iterator<ObjectError> iterator = bindingResult.getAllErrors().iterator();
        StringBuilder sb = new StringBuilder();
        while(iterator.hasNext()){
            sb.append(iterator.next().getDefaultMessage()).append(",");
        }
        if (logger.isErrorEnabled()){
            logger.error("An argument not valid exception has been generated : {}", sb.toString());
        }
        return ResponseUtils.error(ErrorCode.AUTO_CHECK_EXCEPTION, sb.toString());
    }

    @ExceptionHandler({Exception.class})
    @ResponseBody
    public RestfulResponseBody<Object> unknownError(Exception e){
        if (logger.isErrorEnabled()){
            logger.error("An unknown exception has been generated : ", e);
        }
        return ResponseUtils.error(ErrorCode.UNKNOWN_ERROR, ErrorCode.UNKNOWN_ERROR_MESSAGE);
    }

    @ExceptionHandler({AbstractBusinessException.class})
    @ResponseBody
    public RestfulResponseBody<Object> businessException(AbstractBusinessException e){
        if (logger.isErrorEnabled()) {
            logger.error("An business exception has been generated : {}", e.getMessage());
        }
        return ResponseUtils.error(e.getCode(), e.getDetail());
    }
}
