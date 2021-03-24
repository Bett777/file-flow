package com.jgc.file.service;

import com.jgc.common.model.paging.PageQueryParameters;
import com.jgc.common.model.paging.PageResult;
import com.jgc.file.infrastructure.dto.DocumentDTO;
import com.jgc.file.infrastructure.dto.DocumentPageQueryParam;
import com.jgc.file.infrastructure.vo.DocumentListVO;

/**
 * <p>文档管理</p>
 *
 * @author HuMingAn
 * @version 1.0
 * @date 2021/03/10 20:47
 **/
public interface IDocumentService {
    /**
     * 分页查询文档
     * @param parameters /
     * @return /
     */
    PageResult<DocumentListVO> queryDocumentPage(PageQueryParameters<DocumentPageQueryParam> parameters);

    /**
     * 新增文档
     * @param documentDTO /
     */
    void addDocument(DocumentDTO documentDTO);

    /**
     * 删除文档
     * @param documentId /
     */
    void deleteDocument(Long documentId);
}
