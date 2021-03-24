package com.jgc.file.security.infrastructure.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>用户信息</p>
 *
 * @author HuMingAn
 * @version 1.0
 * @date 2021/03/06 14:47
 **/
@TableName(value = "sys_user")
public class AccountEntity {
    /**
     *  用户id
     */
    @TableId(type = IdType.AUTO)
    private Integer userId;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * 是否启用
     */
    private Boolean enabled;
    /**
     * 用户授权
     */
    @TableField(exist = false)
    private List<String> roles;

    public List<SimpleGrantedAuthority> getAuthorities(){
        ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
        roles.forEach(s -> authorities.add(new SimpleGrantedAuthority("ROLE_" + s)));
        return authorities;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
