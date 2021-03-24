package com.jgc.file.security.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jgc.file.security.infrastructure.entity.AccountEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>用户管理</p>
 *
 * @author HuMingAn
 * @version 1.0
 * @date 2021/03/06 14:47
 **/
@Mapper
public interface AccountMapper extends BaseMapper<AccountEntity> {
}
