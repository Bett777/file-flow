package com.jgc.file.infrastructure.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * <p>文档封面图片信息</p>
 *
 * @author HuMingAn
 * @version 1.0
 * @date 2021/03/11 16:43
 **/
@TableName(value = "doc_image_info")
public class ImageEntity{
    /**
     * 图片id
     */
    @TableId(type = IdType.AUTO)
    private Integer imageId;
    /**
     * 图片名称
     */
    private String imageName;
    /**
     * 图片访问地址
     */
    private String imageUrl;

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "ImageEntity{" +
                "imageId=" + imageId +
                ", imageName='" + imageName + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
