package com.jgc.common.exception;

/**
 * <p>自定义异常基础类</p>
 *
 * @author HuMingAn
 * @version 1.0
 * @date 2021/02/18 15:13
 **/
public abstract class AbstractBusinessException extends RuntimeException{
    private int code;
    private String detail;

    public AbstractBusinessException(String message, int code) {
        super(message);
        this.code = code;
        this.detail = message;
    }

    public AbstractBusinessException(String message, Throwable cause, int code) {
        super(message, cause);
        this.code = code;
        this.detail = message;
    }

    public AbstractBusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int code) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
        this.detail = message;
    }

    public int getCode() {
        return code;
    }

    public String getDetail() {
        return detail;
    }
}
