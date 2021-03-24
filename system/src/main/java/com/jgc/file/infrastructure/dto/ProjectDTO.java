package com.jgc.file.infrastructure.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;

/**
 * <p>项目信息DTO</p>
 *
 * @author HuMingAn
 * @version 1.0
 * @date 2021/02/18 16:16
 **/
public class ProjectDTO {
    /**
     * 项目id
     */
    @NotNull(groups = Update.class, message = "项目id不能为空")
    private Integer projectId;
    /**
     * 项目编码
     */
    @NotBlank(message = "项目编码不能为空")
    private String projectCode;
    /**
     * 项目名称
     */
    @NotBlank(message = "项目名称不能为空")
    private String projectName;
    /**
     * 访问地址
     */
    @NotBlank(message = "访问地址不能为空")
    private String path;
    /**
     * 负责项目组id
     */
    @NotNull(message = "负责项目组id不能为空")
    private Long groupId;
    /**
     * 负责项目组名称
     */
    @NotBlank(message = "负责项目组名称不能为空")
    private String groupName;

    public interface Update extends Default{}

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return "ProjectDTO{" +
                "projectId=" + projectId +
                ", projectCode='" + projectCode + '\'' +
                ", projectName='" + projectName + '\'' +
                ", path='" + path + '\'' +
                ", groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                '}';
    }
}
