package com.july.admin.service.impl;

import com.july.admin.beans.ReactAdminAccessDecisionManager;
import com.july.admin.service.FileStoreService;
import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.ConnectException;

/**
 * @author: july
 * @date: 2020/1/15 22:42
 * @description:
 */
@Service("fileStoreService")
public class FtpFileServiceImpl implements FileStoreService {

    private final static Logger logger = LoggerFactory.getLogger(FtpFileServiceImpl.class);

    /**
     * ftp服务器地址
     */
    @Value("${ftp.server.ip}")
    private String server;
    /**
     * 端口
     */
    @Value("${ftp.port}")
    private int port;
    /**
     * 用户名
     */
    @Value("${ftp.user}")
    private String username;
    /**
     *
     */
    @Value("${ftp.pass}")
    private String password;

    public FtpFileServiceImpl() {
    }

    public FtpFileServiceImpl(String server, int port, String username,
                              String password) {
        this.server = server;
        this.port = port;
        this.username = username;
        this.password = password;
    }

    /**
     * 上传文件
     *
     * @param remoteFileName 远程文件名称
     * @param file           文件流
     */
    @Override
    public String upload(String remoteFileName, MultipartFile file) {
        logger.info("upload=>remoteFileName : " + remoteFileName);
        FTPClient ftp = null;
        try {


            ftp = new FTPClient();

            ftp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out), true));
            //连接ftp服务器
            connect(ftp);
            //设置属性
            setProperty(ftp);
            String[] paths = remoteFileName.split("/");

            if (paths.length > 1) {
                mkdir(remoteFileName.substring(remoteFileName.lastIndexOf('/')));
            }
            //上传文件
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(file.getBytes());
            ftp.storeFile(remoteFileName, byteArrayInputStream);
            //退出
            logout(ftp);
            return remoteFileName;
        } catch (Exception e) {
            logger.error("upload=>" + e.getMessage());
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                    logger.error("upload=>" + ioe.getMessage());
                }
            }
        }
        return "";
    }

    /**
     * 创建文件夹
     *
     * @param remotePathName 远程文件夹名称
     */
    public void mkdir(String remotePathName) {
        FTPClient ftp = null;
        try {
            ftp = new FTPClient();
            //ftp.enterLocalPassiveMode();
            ftp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out), true));
            //连接ftp服务器
            connect(ftp);
            //设置属性
            setProperty(ftp);
            //创建文件夹
            mkdir(ftp, remotePathName);
            //退出
            logout(ftp);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException f) {
                }
            }
        }
    }

    /**
     * @param ftp
     * @param remotePathName
     */
    private void mkdir(FTPClient ftp, String remotePathName) throws Exception {
        ftp.makeDirectory(remotePathName);
    }

    /**
     * @param ftp
     * @throws Exception
     */
    private void setProperty(FTPClient ftp) throws Exception {
        //ftp.enterLocalPassiveMode();
        //二进制传输,默认为ASCII
        ftp.setFileType(FTP.BINARY_FILE_TYPE);
    }

    /**
     * @param ftp
     */
    private void logout(FTPClient ftp) throws Exception {
        ftp.noop();
        ftp.logout();
    }

    /**
     * @param ftp
     */
    private void connect(FTPClient ftp) throws Exception {
        //连接服务器
        ftp.connect(server, port);
        int reply = ftp.getReplyCode();
        //是否连接成功
        if (!FTPReply.isPositiveCompletion(reply)) {
            throw new ConnectException(server + " 服务器拒绝连接");
        }
        //登陆
        if (!ftp.login(username, password)) {
            throw new ConnectException("用户名或密码错误");
        }
    }
}