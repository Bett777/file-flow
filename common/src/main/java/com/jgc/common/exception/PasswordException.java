package com.jgc.common.exception;

import com.jgc.common.model.web.ErrorCode;

/**
 * <p>密码异常</p>
 *
 * @author HuMingAn
 * @version 1.0
 * @date 2021/02/18 15:27
 **/
public class PasswordException extends AbstractBusinessException {
    public PasswordException(){
        super(ErrorCode.PASSWORD_EXCEPTION_MESSAGE, ErrorCode.PASSWORD_EXCEPTION);
    }

    public PasswordException(String message) {
        super(message, ErrorCode.PASSWORD_EXCEPTION);
    }
}
