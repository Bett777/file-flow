package com.jgc.file.service.impl;

import com.jgc.common.exception.EmptyException;
import com.jgc.common.exception.SystemException;
import com.jgc.file.config.MinioProperties;
import com.jgc.file.service.IFileService;
import io.minio.*;
import io.minio.errors.*;
import io.minio.messages.Item;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>文件管理服务</p>
 *
 * @author HuMingAn
 * @version 1.0
 * @date 2021/03/09 16:29
 **/
@Service
public class FileServiceImpl implements IFileService {
    private static final Logger log = LoggerFactory.getLogger(FileServiceImpl.class);
    @Resource
    private MinioProperties minioProperties;

    @Resource
    private MinioClient minioClient;

    @Override
    public String uploadFile(MultipartFile file) {
        if (file == null || file.getOriginalFilename() == null){
            throw new EmptyException("文件不能为空");
        }
        String filename = file.getOriginalFilename();
        if (isImage(file)){
            try {
                uploadImage(filename, file.getInputStream());
            } catch (Exception e) {
                if (log.isErrorEnabled()){
                    log.error("上传图片报错: {}", e.getMessage());
                }
                throw new SystemException("上传图片失败");
            }
        }else {
            try {
                uploadDoc(filename, file.getInputStream());
            } catch (Exception e) {
                if (log.isErrorEnabled()){
                    log.error("上传文件报错: {}", e.getMessage());
                }
                throw new SystemException("上传文件失败");
            }
        }
        return filename;
    }

    private void uploadImage(String filename, InputStream inputStream) throws MinioException, NoSuchAlgorithmException, InvalidKeyException, IOException {
        String bucketName = minioProperties.getBucketImage();
        if (!minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build())){
            minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).objectLock(true).build());
            setBucketPolicy(bucketName);
        }
        minioClient.putObject(PutObjectArgs.builder().bucket(bucketName).object(filename)
                .stream(inputStream, inputStream.available(), -1).build());
    }

    private void uploadDoc(String filename, InputStream inputStream) throws MinioException, NoSuchAlgorithmException, InvalidKeyException, IOException {
        String bucketName = minioProperties.getBucketDoc();
        if (!minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build())){
            minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).objectLock(true).build());
        }
        minioClient.putObject(PutObjectArgs.builder().bucket(bucketName).object(filename)
                .stream(inputStream, inputStream.available(), -1).build());
    }

    private void setBucketPolicy(String bucketName) throws IOException, InvalidKeyException, InvalidResponseException, InsufficientDataException, NoSuchAlgorithmException, ServerException, InternalException, XmlParserException, ErrorResponseException {
        String builder = "{\n" +
                "    \"Statement\": [\n" +
                "        {\n" +
                "            \"Action\": [\n" +
                "                \"s3:GetBucketLocation\",\n" +
                "                \"s3:ListBucket\"\n" +
                "            ],\n" +
                "            \"Effect\": \"Allow\",\n" +
                "            \"Principal\": \"*\",\n" +
                "            \"Resource\": \"arn:aws:s3:::" + bucketName +"\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"Action\": \"s3:GetObject\",\n" +
                "            \"Effect\": \"Allow\",\n" +
                "            \"Principal\": \"*\",\n" +
                "            \"Resource\": \"arn:aws:s3:::"+ bucketName + "/*\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Version\": \"2012-10-17\"\n" +
                "}\n";
        minioClient.setBucketPolicy(SetBucketPolicyArgs.builder().bucket(bucketName).config(builder).build());
    }

    @Override
    public void getFile(String filePath, HttpServletResponse response) {
        try {
            InputStream inputStream = minioClient.getObject(GetObjectArgs.builder().bucket(minioProperties.getBucketDoc())
                    .object(filePath).build());
            // Set the content type and attachment header.
            response.addHeader("Content-disposition", "attachment;filename=" + filePath);
            response.setContentType(URLConnection.guessContentTypeFromName(filePath));

            // Copy the stream to the response's output stream.
            IOUtils.copy(inputStream, response.getOutputStream());
            response.flushBuffer();
        } catch (MinioException | IOException | InvalidKeyException | NoSuchAlgorithmException e) {
            if (log.isErrorEnabled()){
                log.error("获取桶图片列表报错: {}", e.getMessage());
            }
            throw new SystemException("读取文件信息失败");
        }
    }

    @Override
    public List<String> getImageList() {
        ArrayList<String> nameList = new ArrayList<>();
        Iterable<Result<Item>> list;
        try {
            list = minioClient.listObjects(ListObjectsArgs.builder().bucket(minioProperties.getBucketImage()).recursive(true).build());
        } catch (Exception e) {
            if (log.isErrorEnabled()){
                log.error("获取桶图片列表报错: {}", e.getMessage());
            }
            throw new SystemException("系统异常");
        }
        list.forEach(s -> {
            try {
                nameList.add(s.get().objectName());
            } catch (Exception e) {
                if (log.isErrorEnabled()){
                    log.error("获取桶图片列表实例的名称报错: {}", e.getMessage());
                }
                throw new SystemException("系统异常");
            }
        });
        return nameList;
    }

    private boolean isImage(MultipartFile file){
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

}


