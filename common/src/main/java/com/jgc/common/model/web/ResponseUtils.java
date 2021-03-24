package com.jgc.common.model.web;

/**
 * <p>返回结果处理工具类</p>
 *
 * @author HuMingAn
 * @version 1.0
 * @date 2021/02/18 14:17
 **/
public class ResponseUtils {
    public static final int SUCCESS_CODE = 10000;
    public static final String SUCCESS_MESSAGE = "success!";

    public static <T> RestfulResponseBody<T> success(T data){
        return setBody(SUCCESS_CODE, SUCCESS_MESSAGE, data);
    }

    public static <T> RestfulResponseBody<T> error(int errorCode, String detail){
        return setBody(errorCode, detail, null);
    }

    private static <T> RestfulResponseBody<T> setBody(int code, String detail, T data){
        RestfulResponseBody<T> responseBody = new RestfulResponseBody<>();
        responseBody.setCode(code);
        responseBody.setMessage(detail);
        responseBody.setData(data);
        return responseBody;
    }
}
