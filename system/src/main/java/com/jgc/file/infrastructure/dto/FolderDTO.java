package com.jgc.file.infrastructure.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;

/**
 * <p>文件夹信息</p>
 *
 * @author HuMingAn
 * @version 1.0
 * @date 2021/03/16 13:25
 **/
public class FolderDTO {
    /**
     * 文件夹id
     */
    @NotNull(message = "文件夹id不能为空", groups = Update.class)
    private Integer folderId;
    /**
     * 文件夹名称
     */
    @NotBlank(message = "文件夹名称不能为空")
    private String folderName;

    public interface Update extends Default{}

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
        return "FolderDTO{" +
                "folderId=" + folderId +
                ", folderName='" + folderName + '\'' +
                '}';
    }
}
