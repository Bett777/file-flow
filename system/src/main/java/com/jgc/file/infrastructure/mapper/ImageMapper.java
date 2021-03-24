package com.jgc.file.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jgc.file.infrastructure.entity.ImageEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>文档封面图片管理</p>
 *
 * @author HuMingAn
 * @version 1.0
 * @date 2021/03/11 16:46
 **/
@Mapper
public interface ImageMapper extends BaseMapper<ImageEntity> {
}
