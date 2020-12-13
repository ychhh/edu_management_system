package com.ychhh.edu_management_system.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.OSSObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.springframework.util.FastByteArrayOutputStream;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Slf4j
public class FileUtil {
    static String FILEHOME="file/";
    public static boolean upload(MultipartFile file){
        try {
            String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1);
            suffix=getFileSuffix(suffix);
            String fileName=FILEHOME+suffix+"/"+file.getOriginalFilename();
            OSSUpload(file,fileName);
            log.debug("已经上传");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("文件上传失败");
        }
        return false;
    }

    /**
     * OSS对象存储文件上传
     * @param file
     * @param fileName
     * @throws IOException
     */
    public static void OSSUpload(MultipartFile file,String fileName) throws IOException {
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "https://oss-cn-beijing.aliyuncs.com";
    // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录RAM控制台创建RAM账号。
        String accessKeyId = "LTAI4GKNr8oT2vPkjwzNRi4W";
        String accessKeySecret = "Y7TZjT1KN1eLt0nFP1xcVhju0BN1vu";
        String bucketName = "edumanagementsystem";
    // <FileName>上传文件到OSS时需要指定包含文件后缀在内的完整路径，例如abc/efg/123.jpg。

    // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

    // 上传文件到指定的存储空间（bucketName）并将其保存为指定的文件名称（objectName）。
    //        String content = "Hello OSS";
        ossClient.putObject(bucketName, fileName, new ByteArrayInputStream(file.getBytes()));

    // 关闭OSSClient。
        ossClient.shutdown();
    }

    /**
     * OSS对象存储文件下载
     * @param fileName
     * @throws IOException
     * @return
     */
    public static void OSSDownload(String fileName, HttpServletResponse response) throws IOException {
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "https://oss-cn-beijing.aliyuncs.com";
        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String accessKeyId = "LTAI4GKNr8oT2vPkjwzNRi4W";
        String accessKeySecret = "Y7TZjT1KN1eLt0nFP1xcVhju0BN1vu";
        String bucketName = "edumanagementsystem";
        //<yourObjectName>表示从OSS下载文件时需要指定包含文件后缀在内的完整路径，例如abc/efg/123.jpg。
        String objectName = fileName;

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // ossObject包含文件所在的存储空间名称、文件名称、文件元信息以及一个输入流。
        OSSObject ossObject = ossClient.getObject(bucketName, objectName);
        OutputStream outputStream=response.getOutputStream();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(ossObject.getObjectContent());
        byte[] b=new byte[1024];
        int len=0;
        while ((len=bufferedInputStream.read(b))!=-1) {
            //不会造成数据损坏
            outputStream.write(b,0,len);
        }
        bufferedInputStream.close();
        outputStream.flush();
        outputStream.close();
        ossObject.close();
        ossClient.shutdown();
    }
        public static String getFileSuffix(String suffix) throws Exception {
        if (suffix.equals("txt")||suffix.equals("doc")||suffix.equals("docx")||suffix.equals("md")){
            suffix="text";
        }else if (suffix.equals("ppt")||suffix.equals("pptx")){
            suffix="ppt";
        }else if (suffix.equals("xls")||suffix.equals("xlsx")||suffix.equals("csv")){
            suffix="table";
        }else if (suffix.equals("jpeg")||suffix.equals("jpg")||suffix.equals("png")){
            suffix="img";
        }else if (suffix.equals("avi")||suffix.equals("mp4")||suffix.equals("rmvb")||suffix.equals("flv")||suffix.equals("mgp")){
            suffix="video";
        }else if (suffix.equals("zip")||suffix.equals("rar")||suffix.equals("7z")||suffix.equals("tar")){
            suffix="zip";
        }else {
            throw new Exception("请上传系统支持的文件类型");
        }
        return suffix;
    }
}
