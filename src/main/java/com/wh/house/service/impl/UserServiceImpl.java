package com.wh.house.service.impl;

import com.wh.house.dao.UserMapper;
import com.wh.house.entity.User;
import com.wh.house.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

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
    public Object save(User user) {
        return null;
    }

    @Override
    public int deleteById(Serializable id) {
        return 0;
    }
}
