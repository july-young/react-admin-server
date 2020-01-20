package com.july.admin.common;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author: july
 * @date: 2020/1/15 22:41
 * @description:
 */
public interface FileStore {

    /**
     * 上传文件
     * @param file
     * @return
     */
    String upload(String remoteFileName, MultipartFile file);

    /**
     * 移除文件
     * @return
     */
    boolean remove(String remoteFileName);

}
