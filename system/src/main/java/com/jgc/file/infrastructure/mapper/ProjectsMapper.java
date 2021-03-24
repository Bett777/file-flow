package com.jgc.file.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jgc.file.infrastructure.entity.ProjectsEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>项目管理mapper</p>
 *
 * @author HuMingAn
 * @version 1.0
 * @date 2021/02/12 18:31
 **/
@Mapper
public interface ProjectsMapper extends BaseMapper<ProjectsEntity> {
}
