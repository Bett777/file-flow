package com.jgc.file.infrastructure.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * <p>文档列表查询参数</p>
 *
 * @author HuMingAn
 * @version 1.0
 * @date 2021/03/10 20:41
 **/
public class DocumentPageQueryParam {
    /**
     * 文档名称
     */
    private String documentName;
    /**
     * 文档类型(1:项目文档 2:公共文档 3:临时文档)
     */
    @NotNull(message = "文档类型不能为空")
    private Integer documentType;
    /**
     * 项目id
     */
    private Integer projectId;
    /**
     * 项目id
     */
    private Integer folderId;

    public Integer getFolderId() {
        return folderId;
    }

    public void setFolderId(Integer folderId) {
        this.folderId = folderId;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public Integer getDocumentType() {
        return documentType;
    }

    public void setDocumentType(Integer documentType) {
        this.documentType = documentType;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    @Override
    public String toString() {
        return "DocumentPageQueryParam{" +
                "documentName='" + documentName + '\'' +
                ", documentType=" + documentType +
                ", projectId=" + projectId +
                '}';
    }
}
