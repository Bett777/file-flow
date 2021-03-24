package com.jgc.file.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jgc.file.infrastructure.entity.FolderEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>文件夹管理</p>
 *
 * @author HuMingAn
 * @version 1.0
 * @date 2021/03/16 13:27
 **/
@Mapper
public interface FolderMapper extends BaseMapper<FolderEntity> {
}
