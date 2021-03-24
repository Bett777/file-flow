package com.jgc.common.utils;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.UUID;

/**
 * <p>图片工具类</p>
 *
 * @author HuMingAn
 * @version 1.0
 * @date 2021/03/22 10:35
 **/
public class ImageUtils {
    public static final String IMAGE__NAME_PREFIX = "image-";

    public static boolean isImage(MultipartFile file){
        try {
            BufferedImage read = ImageIO.read(file.getInputStream());
            if (read != null){
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public static String setImageFileName(String fileName){
        if (StringUtils.hasLength(fileName)){
            return IMAGE__NAME_PREFIX + fileName;
        }else {
            return IMAGE__NAME_PREFIX + UUID.randomUUID();
        }
    }

    public static boolean isImageName(String fileName){
        return fileName.startsWith(ImageUtils.IMAGE__NAME_PREFIX);
    }
}
