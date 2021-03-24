package com.jgc.file.infrastructure.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * <p>项目信息持久化对象</p>
 *
 * @author HuMingAn
 * @version 1.0
 * @date 2021/02/12 18:20
 **/
@TableName(value = "doc_projects")
public class ProjectsEntity {
    /**
     * 项目id
     */
    @TableId(type = IdType.AUTO)
    private Integer projectId;
    /**
     * 项目编码
     */
    private String projectCode;
    /**
     * 项目名称
     */
    private String projectName;
    /**
     * 访问地址
     */
    private String path;
    /**
     * 负责项目组id
     */
    private Long groupId;
    /**
     * 负责项目组名称
     */
    private String groupName;

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
        return "ProjectsEntity{" +
                "projectId=" + projectId +
                ", projectCode='" + projectCode + '\'' +
                ", projectName='" + projectName + '\'' +
                ", path='" + path + '\'' +
                ", groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                '}';
    }
}
