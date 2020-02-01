package com.july.admin.service.impl;

import com.july.admin.service.FileStoreService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author: july
 * @date: 2020/2/1 01:09
 * @description:
 */
@Profile({"pre","dev"})
@Service("fileStoreService")
public class LocalFileServiceImpl  implements FileStoreService{

    @Value("${local-file-store-path}")
    private String fileStorePath;

    @Override
    public String upload(String remoteFileName, MultipartFile file) {
        return null;
    }

    @Override
    public boolean remove(String remoteFileName) {
        return false;
    }
}
