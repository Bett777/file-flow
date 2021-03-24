package com.jgc.common.model.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jgc.common.model.web.ResponseUtils;
import com.jgc.common.model.web.RestfulBody;
import com.jgc.common.model.web.RestfulResponseBody;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * <p>统一封装返回结果的切面</p>
 *
 * @author HuMingAn
 * @version 1.0
 * @date 2021/02/18 15:38
 **/
@RestControllerAdvice(
        annotations = {RestfulBody.class}
)
public class RestfulResponseBodyAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (body == null) {
            return ResponseUtils.success(null);
        } else if (body instanceof String) {
            ObjectMapper objectMapper = new ObjectMapper();
            String value = null;
            try {
                value = objectMapper.writeValueAsString(ResponseUtils.success(body));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            return value;
        } else {
            return RestfulResponseBody.class.isAssignableFrom(body.getClass()) ? body : ResponseUtils.success(body);
        }
    }
}
