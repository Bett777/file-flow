package com.jgc.file.service;

import com.jgc.common.model.paging.PageQueryParameters;
import com.jgc.common.model.paging.PageResult;
import com.jgc.file.infrastructure.dto.ProjectDTO;
import com.jgc.file.infrastructure.dto.ProjectsPageQueryParam;
import com.jgc.file.infrastructure.entity.ProjectsEntity;
import com.jgc.file.infrastructure.vo.ProjectsListVO;

import java.util.List;

/**
 * <p>项目管理服务接口</p>
 *
 * @author HuMingAn
 * @version 1.0
 * @date 2021/02/12 18:14
 **/
public interface IProjectService {
    /**
     * 查询项目列表
     * @param parameters /
     * @return /
     */
    PageResult<ProjectsListVO> listProjects(PageQueryParameters<ProjectsPageQueryParam> parameters);

    /**
     * 添加项目
     * @param projectDTO /
     */
    void insertProjectInfo(ProjectDTO projectDTO);

    /**
     * 修改项目信息
     * @param projectDTO /
     */
    void updateProjectInfo(ProjectDTO projectDTO);

    /**
     * 删除项目
     * @param projectId /
     */
    void deleteProject(Integer projectId);

    /**
     * ..
     * @return /
     */
    List<ProjectsEntity> list();
}
