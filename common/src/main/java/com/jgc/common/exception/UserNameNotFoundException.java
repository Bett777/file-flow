package com.jgc.common.exception;

import com.jgc.common.model.web.ErrorCode;

/**
 * @author shuang.kou
 */
public class UserNameNotFoundException extends AbstractBusinessException {
    public UserNameNotFoundException(){
        super(ErrorCode.USER_NAME_NOT_FOUND_MESSAGE, ErrorCode.USER_NAME_NOT_FOUND);
    }

    public UserNameNotFoundException(String message) {
        super(message, ErrorCode.USER_NAME_NOT_FOUND);
    }
}
