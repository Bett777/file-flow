package com.jgc.file.service;

import com.jgc.common.model.paging.PageQueryParameters;
import com.jgc.common.model.paging.PageResult;
import com.jgc.file.infrastructure.dto.DocumentPageQueryParam;
import com.jgc.file.infrastructure.entity.ImageEntity;
import com.jgc.file.infrastructure.vo.DocumentListVO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>文件管理</p>
 *
 * @author HuMingAn
 * @version 1.0
 * @date 2021/03/09 16:29
 **/
public interface IFileService {
    /**
     * 上传文件
     * @param file /
     * @return /
     */
    String uploadFile(MultipartFile file);

    /**
     * 下载文件
     * @param filePath /
     * @param response /
     */
    void getFile(String filePath, HttpServletResponse response);

    /**
     * 查询图片集合
     * @return /
     */
    List<String> getImageList();
}
