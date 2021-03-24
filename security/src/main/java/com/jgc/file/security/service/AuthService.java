package com.jgc.file.security.service;

import com.jgc.file.security.common.constants.SecurityConstants;
import com.jgc.file.security.infrastructure.dto.LoginDTO;
import com.jgc.file.security.infrastructure.entity.AccountEntity;
import com.jgc.file.security.infrastructure.entity.JwtUserDetails;
import com.jgc.file.security.infrastructure.vo.LoginVO;
import com.jgc.file.security.utils.CurrentUserUtils;
import com.jgc.file.security.utils.JwtTokenUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>授权服务</p>
 *
 * @author HuMingAn
 * @version 1.0
 * @date 2021/03/06 11:27
 **/
@Service
public class AuthService {
    @Resource
    private AccountService accountService;

    @Resource
    private CurrentUserUtils currentUserUtils;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    public LoginVO createToken(LoginDTO loginDTO) {
        AccountEntity user = accountService.findAccountByUserName(loginDTO.getUsername());
        ArrayList<String> roles = new ArrayList<>();
        roles.add("ADMIN");
        user.setRoles(roles);
        if (!accountService.check(loginDTO.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("用户名或密码错误");
        }
        JwtUserDetails jwtUser = new JwtUserDetails(user);
        if (!jwtUser.isEnabled()) {
            throw new BadCredentialsException("用户已被禁用");
        }
        List<String> authorities = jwtUser.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        String token = JwtTokenUtils.createToken(user.getUserName(), user.getUserId().toString(), authorities, loginDTO.getRememberMe());
        stringRedisTemplate.opsForSet().add(user.getUserId().toString(), token);
        return new LoginVO(user.getUserId(), user.getUserName(), token);
    }

    public void removeToken(HttpServletRequest request) {
        String token = request.getHeader(SecurityConstants.TOKEN_HEADER);
        String key = currentUserUtils.getCurrentUser().getUserId().toString();
        stringRedisTemplate.opsForSet().remove(key, token);
    }
}
