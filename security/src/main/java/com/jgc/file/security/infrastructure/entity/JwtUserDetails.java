package com.jgc.file.security.infrastructure.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * <p>用户信息</p>
 *
 * @author HuMingAn
 * @version 1.0
 * @date 2021/03/06 15:29
 **/
public class JwtUserDetails implements UserDetails {
    private Integer userId;
    private String username;
    private String password;
    private Boolean enabled;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtUserDetails() {
    }

    /**
     * 通过 user 对象创建jwtUser
     */
    public JwtUserDetails(AccountEntity user) {
        userId = user.getUserId();
        username = user.getUserName();
        password = user.getPassword();
        enabled = user.getEnabled() == null ? true : user.getEnabled();
        authorities = user.getAuthorities();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public String toString() {
        return "JwtUserDetails{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", authorities=" + authorities +
                '}';
    }
}
