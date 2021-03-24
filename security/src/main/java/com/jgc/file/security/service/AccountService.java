package com.jgc.file.security.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jgc.common.exception.UserNameNotFoundException;
import com.jgc.file.security.infrastructure.entity.AccountEntity;
import com.jgc.file.security.infrastructure.mapper.AccountMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>用户管理</p>
 *
 * @author HuMingAn
 * @version 1.0
 * @date 2021/03/06 15:06
 **/
@Service
public class AccountService {
    @Resource
    private AccountMapper accountMapper;

    @Resource
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public AccountEntity findAccountByUserName(String username) {
        QueryWrapper<AccountEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", username);
        AccountEntity accountEntity = accountMapper.selectOne(queryWrapper);
        if (accountEntity == null){
            throw new UserNameNotFoundException("用户不存在!");
        }
        return accountEntity;
    }

    boolean check(String currentPassword, String password) {
        return bCryptPasswordEncoder.matches(currentPassword, password);
    }
}
