package com.jgc.file.security.infrastructure.dto;

import javax.validation.constraints.NotBlank;

/**
 * <p>登陆信息</p>
 *
 * @author HuMingAn
 * @version 1.0
 * @date 2021/03/06 14:57
 **/
public class LoginDTO {
    /**
     * 用户名称
     */
    @NotBlank(message = "用户名称不能为空")
    private String username;
    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    private String password;
    /**
     * 记住我
     */
    private Boolean rememberMe;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(Boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

    @Override
    public String toString() {
        return "LoginDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", rememberMe=" + rememberMe +
                '}';
    }
}
