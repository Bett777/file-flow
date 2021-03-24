package com.jgc.file.controller;

import com.jgc.common.model.web.RestfulBody;
import com.jgc.file.infrastructure.entity.ImageEntity;
import com.jgc.file.service.IFileService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * <p>文件管理</p>
 *
 * @author HuMingAn
 * @version 1.0
 * @date 2021/03/09 16:23
 **/
@RestController
@RestfulBody
@RequestMapping("/files")
public class FileController {
    @Resource
    private IFileService fileService;

    @PostMapping
    public String uploadFile(MultipartFile file){
        return fileService.uploadFile(file);
    }

    @GetMapping
    public void getFile(@RequestParam("filePath") @NotNull String filePath, HttpServletResponse response){
        fileService.getFile(filePath, response);
    }

    @GetMapping("/image")
    public List<String> getImageList(){
        return fileService.getImageList();
    }
}
