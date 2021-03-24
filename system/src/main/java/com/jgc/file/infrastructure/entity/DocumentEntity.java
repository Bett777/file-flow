package com.jgc.file.infrastructure.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

/**
 * <p>文档信息</p>
 *
 * @author HuMingAn
 * @version 1.0
 * @date 2021/03/10 14:15
 **/
@TableName(value = "doc_documents")
public class DocumentEntity {
    /**
     * 文档id
     */
    @TableId(type = IdType.AUTO)
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
    private Integer documentType;
    /**
     * 文档名称
     */
    private String documentName;
    /**
     * 文档背景图片地址
     */
    private String imageUrl;
    /**
     * 文档下载地址
     */
    private String documentUrl;
    /**
     * 文档上传时间
     */
    private Date uploadTime;

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

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    @Override
    public String toString() {
        return "DocumentEntity{" +
                "documentId=" + documentId +
                ", projectId=" + projectId +
                ", documentType=" + documentType +
                ", documentName='" + documentName + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", documentUrl='" + documentUrl + '\'' +
                ", uploadTime=" + uploadTime +
                '}';
    }
}
