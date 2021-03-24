package com.jgc.file.security.controller;

import com.jgc.common.model.web.RestfulBody;
import com.jgc.file.security.infrastructure.dto.LoginDTO;
import com.jgc.file.security.infrastructure.vo.LoginVO;
import com.jgc.file.security.service.AuthService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>授权管理</p>
 *
 * @author HuMingAn
 * @version 1.0
 * @date 2021/03/06 11:24
 **/
@RestController
@RestfulBody
@RequestMapping("/auth")
public class AuthController {
    @Resource
    private AuthService authService;

    @PostMapping("/login")
    public LoginVO login(@RequestBody @Validated LoginDTO loginDTO){
        return authService.createToken(loginDTO);
    }

    @PostMapping("/logout")
    public void logout(HttpServletRequest request){
        authService.removeToken(request);
    }
}
