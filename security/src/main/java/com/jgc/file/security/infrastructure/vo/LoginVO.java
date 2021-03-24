package com.jgc.file.security.infrastructure.vo;

/**
 * <p>登陆返回信息</p>
 *
 * @author HuMingAn
 * @version 1.0
 * @date 2021/03/06 16:12
 **/
public class LoginVO {
    private Integer userId;
    private String userName;
    private String token;

    public LoginVO(Integer userId, String userName, String token) {
        this.userId = userId;
        this.userName = userName;
        this.token = token;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "LoginVO{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
