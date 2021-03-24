package com.jgc.common.model.web;

import java.io.Serializable;
import java.util.Objects;

/**
 * <p>web接口返回结果封装对象</p>
 *
 * @author HuMingAn
 * @version 1.0
 * @date 2021/02/18 11:30
 **/
public class RestfulResponseBody<T> implements Serializable {
    private int code;
    private String message;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RestfulResponseBody<?> that = (RestfulResponseBody<?>) o;
        return code == that.code &&
                Objects.equals(message, that.message) &&
                Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, message, data);
    }

    @Override
    public String toString() {
        return "RestfulResponseBody{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
