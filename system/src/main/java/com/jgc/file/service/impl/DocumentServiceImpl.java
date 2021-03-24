package com.jgc.file.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jgc.common.model.paging.PageQueryParameters;
import com.jgc.common.model.paging.PageResult;
import com.jgc.common.model.paging.Paging;
import com.jgc.common.utils.ListCopyUtils;
import com.jgc.file.infrastructure.dto.DocumentDTO;
import com.jgc.file.infrastructure.dto.DocumentPageQueryParam;
import com.jgc.file.infrastructure.entity.DocumentEntity;
import com.jgc.file.infrastructure.mapper.DocumentMapper;
import com.jgc.file.infrastructure.vo.DocumentListVO;
import com.jgc.file.service.IDocumentService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;

/**
 * <p>文档管理</p>
 *
 * @author HuMingAn
 * @version 1.0
 * @date 2021/03/10 20:48
 **/
@Service
public class DocumentServiceImpl implements IDocumentService {
    @Resource
    private DocumentMapper documentMapper;

    @Override
    public PageResult<DocumentListVO> queryDocumentPage(PageQueryParameters<DocumentPageQueryParam> parameters) {
        PageResult<DocumentListVO> result = new PageResult<>();
        Paging paging = parameters.getPaging();
        DocumentPageQueryParam params = parameters.getParams();
        Page<DocumentEntity> page = new Page<>(paging.getPageNumber(), paging.getPageSize());
        QueryWrapper<DocumentEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(params.getProjectId() != null, "project_id", params.getProjectId())
                .eq(params.getFolderId() != null, "folder_id", params.getFolderId())
                .eq("document_type", params.getDocumentType())
                .like(StringUtils.hasLength(params.getDocumentName()), "document_name", params.getDocumentName());
        Page<DocumentEntity> entityPage = documentMapper.selectPage(page, queryWrapper);
        paging.setTotalNumber(entityPage.getTotal());
        paging.setTotalPage((int) entityPage.getPages());
        result.setPaging(paging);
        result.setData(ListCopyUtils.copyListProperties(entityPage.getRecords(), DocumentListVO::new));
        return result;
    }

    @Override
    public void addDocument(DocumentDTO documentDTO) {
        DocumentEntity documentEntity = new DocumentEntity();
        BeanUtils.copyProperties(documentDTO, documentEntity);
        documentEntity.setUploadTime(new Date());
        documentMapper.insert(documentEntity);
    }

    @Override
    public void deleteDocument(Long documentId) {
        documentMapper.deleteById(documentId);
    }
}
