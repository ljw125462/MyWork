package com.example.powermanager.service.impl;

import com.example.powermanager.dao.UserDao;
import com.example.powermanager.model.SysUser;
import com.example.powermanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public SysUser getUser(String username){
        return userDao.getUser(username);
    }
}
