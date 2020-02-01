package com.july.admin.service.impl;

import com.july.admin.service.FileStoreService;
import com.july.admin.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @author: july
 * @date: 2020/2/1 01:09
 * @description:
 */
@Profile({"pre","dev"})
@Service("fileStoreService")
public class LocalFileServiceImpl  implements FileStoreService{

    private static Logger logger= LoggerFactory.getLogger(LocalFileServiceImpl.class);

    @Value("${local-file-store-path}")
    private String fileStorePath;

    @Override
    public String upload(String remoteFileName, MultipartFile multipartFile) {
        //直接返回文件的名字
        String name=multipartFile.getOriginalFilename();
        //我这里取得文件后缀
        String subffix = name.substring(name.lastIndexOf(".") + 1, name.length());

        //文件保存进来，我给他重新命名，数据库保存有原本的名字，所以输出的时候再把他附上原本的名字就行了。
        String fileName=DateUtil.format(new Date(),DateUtil.FILE_RENAME_PATTERN)+"."+subffix;
        File file=new File(fileStorePath);
        //目录不存在就创建
        if(!file.exists()){
            file.mkdirs();
        }
        try {
            File newFile = new File(fileStorePath + fileName);
            //保存文件
            multipartFile.transferTo(newFile);
            //newFile.createNewFile();
            return fileName;
        } catch (IOException e) {
            logger.error("upload=>"+e.getMessage());
        }
        return null;
    }

    @Override
    public boolean remove(String remoteFileName) {
        File file =new File(fileStorePath+remoteFileName);
        return file.delete();
    }
}
