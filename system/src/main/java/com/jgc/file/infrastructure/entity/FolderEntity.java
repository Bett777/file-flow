package com.jgc.file.infrastructure.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * <p>文件夹信息</p>
 *
 * @author HuMingAn
 * @version 1.0
 * @date 2021/03/16 13:28
 **/
@TableName(value = "doc_folders")
public class FolderEntity {
    @TableId(type = IdType.AUTO)
    private Integer folderId;
    private String folderName;

    public Integer getFolderId() {
        return folderId;
    }

    public void setFolderId(Integer folderId) {
        this.folderId = folderId;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    @Override
    public String toString() {
        return "FolderEntity{" +
                "folderId=" + folderId +
                ", folderName='" + folderName + '\'' +
                '}';
    }
}
