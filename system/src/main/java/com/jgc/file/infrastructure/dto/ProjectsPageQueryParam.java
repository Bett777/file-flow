package com.jgc.file.infrastructure.dto;

/**
 * <p>项目集合查询参数</p>
 *
 * @author HuMingAn
 * @version 1.0
 * @date 2021/02/12 22:07
 **/
public class ProjectsPageQueryParam {
    private String projectName;
    private Long groupId;
    private String projectCode;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    @Override
    public String toString() {
        return "ProjectsPageQueryParam{" +
                "projectName='" + projectName + '\'' +
                ", groupId=" + groupId +
                ", projectCode='" + projectCode + '\'' +
                '}';
    }
}
