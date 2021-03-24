package com.jgc.file.controller;

import com.jgc.common.model.web.RestfulBody;
import com.jgc.file.infrastructure.dto.FolderDTO;
import com.jgc.file.infrastructure.entity.FolderEntity;
import com.jgc.file.service.IFolderService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * <p>文件夹管理</p>
 *
 * @author HuMingAn
 * @version 1.0
 * @date 2021/03/16 13:24
 **/
@RestController
@RestfulBody
@RequestMapping("/folder")
public class FolderController {
    @Resource
    private IFolderService folderService;

    @GetMapping
    private List<FolderEntity> findFolderList(){
        return folderService.findFolderList();
    }

    @PostMapping
    private void insertFolder(@RequestBody @Validated FolderDTO folderDTO){
        folderService.insertFolder(folderDTO);
    }

    @PutMapping
    private void updateFolder(@RequestBody @Validated(FolderDTO.Update.class) FolderDTO folderDTO){
        folderService.updateFolder(folderDTO);
    }

    @DeleteMapping
    private void deleteFolder(@RequestParam @NotNull Integer folderId){
        folderService.deleteFolder(folderId);
    }
}
