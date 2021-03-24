package com.jgc.file.controller;

import com.jgc.common.model.paging.PageQueryParameters;
import com.jgc.common.model.paging.PageResult;
import com.jgc.common.model.web.ResponseUtils;
import com.jgc.common.model.web.RestfulBody;
import com.jgc.file.infrastructure.dto.ProjectDTO;
import com.jgc.file.infrastructure.dto.ProjectsPageQueryParam;
import com.jgc.file.infrastructure.entity.ProjectsEntity;
import com.jgc.file.infrastructure.vo.ProjectsListVO;
import com.jgc.file.service.IProjectService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>项目管理controller</p>
 *
 * @author HuMingAn
 * @version 1.0
 * @date 2021/02/12 18:12
 **/
@RestController
@RestfulBody
@RequestMapping("/projects")
public class ProjectsController {
    @Resource
    private IProjectService projectService;

    @PostMapping("/page")
    public PageResult<ProjectsListVO> listProjects(@RequestBody @Validated PageQueryParameters<ProjectsPageQueryParam> parameters){
        return projectService.listProjects(parameters);
    }

    @PostMapping
    public String insertProjectInfo(@RequestBody @Validated ProjectDTO projectDTO){
        projectService.insertProjectInfo(projectDTO);
        return ResponseUtils.SUCCESS_MESSAGE;
    }

    @PutMapping
    public String updateProjectInfo(@RequestBody @Validated(ProjectDTO.Update.class) ProjectDTO projectDTO){
        projectService.updateProjectInfo(projectDTO);
        return ResponseUtils.SUCCESS_MESSAGE;
    }

    @DeleteMapping
    public String deleteProject(@RequestParam Integer projectId){
        projectService.deleteProject(projectId);
        return ResponseUtils.SUCCESS_MESSAGE;
    }
    @GetMapping
    public List<ProjectsEntity> list(){
        return projectService.list();
    }

}
