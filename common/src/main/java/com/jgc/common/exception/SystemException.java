package com.jgc.common.exception;

import com.jgc.common.model.web.ErrorCode;

/**
 * <p>空值异常</p>
 *
 * @author HuMingAn
 * @version 1.0
 * @date 2021/02/18 15:22
 **/
public class SystemException extends AbstractBusinessException {
    public SystemException(){
        super(ErrorCode.EMPTY_EXCEPTION_MESSAGE, ErrorCode.EMPTY_EXCEPTION);
    }

    public SystemException(String message) {
        super(message, ErrorCode.EMPTY_EXCEPTION);
    }
}
