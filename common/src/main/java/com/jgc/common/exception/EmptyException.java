package com.jgc.common.exception;

import com.jgc.common.model.web.ErrorCode;

/**
 * <p>空值异常</p>
 *
 * @author HuMingAn
 * @version 1.0
 * @date 2021/02/18 15:22
 **/
public class EmptyException extends AbstractBusinessException {
    public EmptyException(){
        super(ErrorCode.SYSTEM_EXCEPTION_MESSAGE, ErrorCode.SYSTEM_EXCEPTION);
    }

    public EmptyException(String message) {
        super(message, ErrorCode.SYSTEM_EXCEPTION);
    }
}
