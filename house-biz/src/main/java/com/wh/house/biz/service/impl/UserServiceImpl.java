package com.wh.house.biz.service.impl;

import com.google.common.collect.Lists;
import com.wh.house.common.dao.UserMapper;
import com.wh.house.common.entity.User;
import com.wh.house.common.service.FileService;
import com.wh.house.common.service.UserService;
import com.wh.house.common.util.RegisterCache;
import com.wh.house.common.util.SendMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Autowired
    private FileService fileService;
    @Autowired
    private SendMail sendMail;
    @Value("${domain.name}")
    private String domainName;

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User getById(Serializable id) {
        return userMapper.selectByPrimaryKey((Integer) id);
    }

    @Override
    public int updateById(User user) {
        return 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Object save(User user) {
        // 保存头像文件
        List<String> list = fileService.saveFile(Lists.newArrayList(user.getFile()));
        user.setAvatar(list.get(0));
        // 发送验证邮件
        sendMail.sendMail(user.getUsername());
        return userMapper.insert(user);
    }


    @Override
    public int deleteById(Serializable id) {
        return 0;
    }
}
