package com.jgc.file.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jgc.file.infrastructure.entity.DocumentEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>文档管理</p>
 *
 * @author HuMingAn
 * @version 1.0
 * @date 2021/03/10 14:19
 **/
@Mapper
public interface DocumentMapper extends BaseMapper<DocumentEntity> {
}
