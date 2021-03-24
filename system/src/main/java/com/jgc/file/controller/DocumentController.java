package com.jgc.file.controller;

import com.jgc.common.model.paging.PageQueryParameters;
import com.jgc.common.model.paging.PageResult;
import com.jgc.common.model.web.RestfulBody;
import com.jgc.file.infrastructure.dto.DocumentDTO;
import com.jgc.file.infrastructure.dto.DocumentPageQueryParam;
import com.jgc.file.infrastructure.vo.DocumentListVO;
import com.jgc.file.service.IDocumentService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

/**
 * <p>文档管理</p>
 *
 * @author HuMingAn
 * @version 1.0
 * @date 2021/03/10 14:04
 **/
@RestController
@RestfulBody
@RequestMapping("/documents")
public class DocumentController {
    @Resource
    private IDocumentService documentService;

    @PostMapping("/page")
    public PageResult<DocumentListVO> queryDocumentPage(@RequestBody @Validated PageQueryParameters<DocumentPageQueryParam> parameters){
        return documentService.queryDocumentPage(parameters);
    }

    @PostMapping
    public void addDocument(@RequestBody @Validated DocumentDTO documentDTO){
        documentService.addDocument(documentDTO);
    }

    @DeleteMapping
    public void deleteDocument(@RequestParam @NotNull Long documentId){
        documentService.deleteDocument(documentId);
    }
}
