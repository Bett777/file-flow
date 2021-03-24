package com.jgc.file.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jgc.common.exception.IllegalValueException;
import com.jgc.common.model.paging.PageQueryParameters;
import com.jgc.common.model.paging.PageResult;
import com.jgc.common.model.paging.Paging;
import com.jgc.common.utils.ListCopyUtils;
import com.jgc.file.infrastructure.dto.ProjectDTO;
import com.jgc.file.infrastructure.dto.ProjectsPageQueryParam;
import com.jgc.file.infrastructure.entity.DocumentEntity;
import com.jgc.file.infrastructure.entity.ProjectsEntity;
import com.jgc.file.infrastructure.mapper.DocumentMapper;
import com.jgc.file.infrastructure.mapper.ProjectsMapper;
import com.jgc.file.infrastructure.vo.ProjectsListVO;
import com.jgc.file.service.IProjectService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>项目管理服务接口实现</p>
 *
 * @author HuMingAn
 * @version 1.0
 * @date 2021/02/12 18:15
 **/
@Service
public class ProjectServiceImpl implements IProjectService {
    @Resource
    private ProjectsMapper projectsMapper;

    @Resource
    private DocumentMapper documentMapper;
    
    @Override
    public PageResult<ProjectsListVO> listProjects(PageQueryParameters<ProjectsPageQueryParam> parameters) {
        Paging paging = parameters.getPaging();
        ProjectsPageQueryParam params = parameters.getParams();
        Page<ProjectsEntity> page = new Page<>(paging.getPageNumber(), paging.getPageSize());
        QueryWrapper<ProjectsEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.hasLength(params.getProjectName()), "project_name", params.getProjectName()).
                eq(params.getGroupId() != null, "group_id", params.getGroupId()).
                orderByDesc("project_id");
        Page<ProjectsEntity> entityPage = projectsMapper.selectPage(page, queryWrapper);
        List<ProjectsEntity> records = entityPage.getRecords();
        List<ProjectsListVO> projectsListVOList = ListCopyUtils.copyListProperties(records, ProjectsListVO::new);
        PageResult<ProjectsListVO> result = new PageResult<>();
        result.setData(projectsListVOList);
        paging.setTotalNumber(entityPage.getTotal());
        paging.setTotalPage((int) entityPage.getPages());
        result.setPaging(paging);
        return result;
    }

    @Override
    public void insertProjectInfo(ProjectDTO projectDTO) {
        ProjectsEntity projectsEntity = new ProjectsEntity();
        BeanUtils.copyProperties(projectDTO, projectsEntity);
        projectsMapper.insert(projectsEntity);
    }

    @Override
    public void updateProjectInfo(ProjectDTO projectDTO) {
        ProjectsEntity projectsEntity = new ProjectsEntity();
        BeanUtils.copyProperties(projectDTO, projectsEntity);
        projectsMapper.updateById(projectsEntity);
    }

    @Override
    public void deleteProject(Integer projectId) {
        QueryWrapper<DocumentEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("project_id", projectId);
        Integer integer = documentMapper.selectCount(queryWrapper);
        if (!integer.equals(0)){
            throw new IllegalValueException("项目下存在文档, 不允许删除");
        }
        projectsMapper.deleteById(projectId);
    }

    @Override
    public List<ProjectsEntity> list() {
        return projectsMapper.selectList(null);
    }
}
