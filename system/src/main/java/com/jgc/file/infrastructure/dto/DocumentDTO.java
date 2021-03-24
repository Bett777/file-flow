package com.jgc.file.infrastructure.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;

/**
 * <p>文档DTO</p>
 *
 * @author HuMingAn
 * @version 1.0
 * @date 2021/03/10 14:21
 **/
public class DocumentDTO {
    /**
     * 文档id
     */
    @NotNull(message = "文档id不能为空", groups = Update.class)
    private Integer documentId;
    /**
     * 项目id
     */
    private Integer projectId;
    /**
     * 项目id
     */
    private Integer folderId;
    /**
     * 文档类型(1:项目文档 2:公共文档 3:临时文档)
     */
    @NotNull(message = "文档类型不能为空")
    private Integer documentType;
    /**
     * 文档名称
     */
    @NotBlank(message = "文档名称不能为空")
    private String documentName;
    /**
     * 文档背景图片地址
     */
    @NotBlank(message = "文档背景图片地址不能为空")
    private String imageUrl;
    /**
     * 文档下载地址
     */
    @NotBlank(message = "文档下载地址不能为空")
    private String documentUrl;

    private interface Update extends Default{}

    public Integer getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Integer documentId) {
        this.documentId = documentId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getFolderId() {
        return folderId;
    }

    public void setFolderId(Integer folderId) {
        this.folderId = folderId;
    }

    public Integer getDocumentType() {
        return documentType;
    }

    public void setDocumentType(Integer documentType) {
        this.documentType = documentType;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDocumentUrl() {
        return documentUrl;
    }

    public void setDocumentUrl(String documentUrl) {
        this.documentUrl = documentUrl;
    }

    @Override
    public String toString() {
        return "DocumentDTO{" +
                "documentId=" + documentId +
                ", documentType=" + documentType +
                ", documentName='" + documentName + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", documentUrl='" + documentUrl + '\'' +
                '}';
    }
}
