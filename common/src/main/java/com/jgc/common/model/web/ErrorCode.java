package com.jgc.common.model.web;

/**
 * <p>异常编码常量类</p>
 *
 * @author HuMingAn
 * @version 1.0
 * @date 2021/02/18 14:54
 **/
public class ErrorCode {
    public static final int UNKNOWN_ERROR = 10001;
    public static final String UNKNOWN_ERROR_MESSAGE = "unknown error!";
    public static final int EMPTY_EXCEPTION = 10002;
    public static final String EMPTY_EXCEPTION_MESSAGE = "empty value!";
    public static final int ILLEGAL_VALUE_EXCEPTION = 10003;
    public static final String ILLEGAL_VALUE_MESSAGE = "illegal value!";
    public static final int PASSWORD_EXCEPTION = 10004;
    public static final String PASSWORD_EXCEPTION_MESSAGE = "wrong password!";
    public static final int AUTO_CHECK_EXCEPTION = 10005;
    public static final int SYSTEM_EXCEPTION = 10006;
    public static final String SYSTEM_EXCEPTION_MESSAGE = "system error!";
    public static final int USER_NAME_NOT_FOUND = 11001;
    public static final String USER_NAME_NOT_FOUND_MESSAGE = "userName not found!";
}
