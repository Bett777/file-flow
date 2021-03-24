package com.jgc.common.exception;

import com.jgc.common.model.web.ErrorCode;

/**
 * <p>非法值异常</p>
 *
 * @author HuMingAn
 * @version 1.0
 * @date 2021/02/18 15:25
 **/
public class IllegalValueException extends AbstractBusinessException {
    public IllegalValueException(){
        super(ErrorCode.ILLEGAL_VALUE_MESSAGE, ErrorCode.ILLEGAL_VALUE_EXCEPTION);
    }

    public IllegalValueException(String message) {
        super(message, ErrorCode.ILLEGAL_VALUE_EXCEPTION);
    }
}
