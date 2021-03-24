package com.jgc.file.security.utils;

import com.jgc.file.security.infrastructure.entity.AccountEntity;
import com.jgc.file.security.service.AccountService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author shuang.kou
 * @description 获取当前请求的用户
 */
@Component
public class CurrentUserUtils {
    @Resource
    private AccountService accountService;

    public AccountEntity getCurrentUser() {
        return accountService.findAccountByUserName(getCurrentUserName());
    }

    private String getCurrentUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() != null) {
            return (String) authentication.getPrincipal();
        }
        return null;
    }
}
