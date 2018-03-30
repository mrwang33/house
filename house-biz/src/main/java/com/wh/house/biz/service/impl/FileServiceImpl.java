package com.wh.house.biz.service.impl;

import com.google.common.collect.Lists;
import com.google.common.io.Files;
import com.wh.house.common.service.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class FileServiceImpl implements FileService {
    @Value("${file.path}")
    private String prefixPath;

    @Override
    public List<String> saveFile(List<MultipartFile> files) {
        List<String> path = Lists.newArrayList();
        files.forEach(file -> {
            try {
                String s = saveLocalFile(file);
                path.add(s);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        return path;
    }

    private String saveLocalFile(MultipartFile file) throws IOException{
        File localFile = new File(prefixPath+"/"+System.currentTimeMillis()+"/"+file.getOriginalFilename());
        if (!localFile.exists()) {
            localFile.getParentFile().mkdir();
            localFile.createNewFile();
        }

        Files.write(file.getBytes(),localFile);
        return localFile.getAbsolutePath();
    }
}
