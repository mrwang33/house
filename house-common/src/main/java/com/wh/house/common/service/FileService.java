package com.wh.house.common.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {

    /**
     * 保存多文件
     * @param files
     * @return 文件保存的路径
     */
    List<String> saveFile(List<MultipartFile> files);
}
