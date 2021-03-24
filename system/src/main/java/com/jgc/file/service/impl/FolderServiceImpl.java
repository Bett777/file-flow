package com.jgc.file.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jgc.common.exception.IllegalValueException;
import com.jgc.file.infrastructure.dto.FolderDTO;
import com.jgc.file.infrastructure.entity.FolderEntity;
import com.jgc.file.infrastructure.mapper.FolderMapper;
import com.jgc.file.service.IFolderService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>文件夹管理</p>
 *
 * @author HuMingAn
 * @version 1.0
 * @date 2021/03/16 13:32
 **/
@Service
public class FolderServiceImpl implements IFolderService {
    private static final String DEFAULT_FOLDER_NAME = "所有文档";

    @Resource
    private FolderMapper folderMapper;

    @Override
    public List<FolderEntity> findFolderList() {
        return folderMapper.selectList(null);
    }

    @Override
    public void insertFolder(FolderDTO folderDTO) {
        checkFolderName(folderDTO);
        FolderEntity folderEntity = new FolderEntity();
        BeanUtils.copyProperties(folderDTO, folderEntity);
        folderMapper.insert(folderEntity);
    }

    @Override
    public void updateFolder(FolderDTO folderDTO) {
        checkFolderName(folderDTO);
        FolderEntity folderEntity = new FolderEntity();
        BeanUtils.copyProperties(folderDTO, folderEntity);
        folderMapper.updateById(folderEntity);
    }

    @Override
    public void deleteFolder(Integer folderId) {
        folderMapper.deleteById(folderId);
    }

    private void checkFolderName(FolderDTO folderDTO) {
        QueryWrapper<FolderEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("folder_name", folderDTO.getFolderName())
                .ne(folderDTO.getFolderId() != null, "folder_id", folderDTO.getFolderId());
        Integer count = folderMapper.selectCount(queryWrapper);
        if (count != 0 || DEFAULT_FOLDER_NAME.equals(folderDTO.getFolderName())){
            throw new IllegalValueException("文件名重复");
        }
    }
}
