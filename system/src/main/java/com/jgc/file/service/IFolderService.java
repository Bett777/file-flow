package com.jgc.file.service;

import com.jgc.file.infrastructure.dto.FolderDTO;
import com.jgc.file.infrastructure.entity.FolderEntity;

import java.util.List;

/**
 * <p>文件夹管理</p>
 *
 * @author HuMingAn
 * @version 1.0
 * @date 2021/03/16 13:32
 **/
public interface IFolderService {
    /**
     * 查询所有文件夹
     * @return /
     */
    List<FolderEntity> findFolderList();

    /**
     * 添加文件夹
     * @param folderDTO /
     */
    void insertFolder(FolderDTO folderDTO);

    /**
     * 编辑文件夹
     * @param folderDTO /
     */
    void updateFolder(FolderDTO folderDTO);

    /**
     * 删除文件夹
     * @param folderId /
     */
    void deleteFolder(Integer folderId);
}
