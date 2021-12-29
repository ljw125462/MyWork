package com.example.powermanager.service.impl;

import com.example.powermanager.base.result.Results;
import com.example.powermanager.dao.RoleDao;
import com.example.powermanager.dao.RoleUserDao;
import com.example.powermanager.model.SysRoleUser;
import com.example.powermanager.service.RoleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleUserServiceImpl implements RoleUserService {

    @Autowired
    private RoleUserDao roleUserDao;

    @Override
    public Results getSysRoleUserByUserId(Integer userId) {
        SysRoleUser sysRoleUser = roleUserDao.getSysRoleUserByUserId(userId);
        if(sysRoleUser != null){
            return Results.success(sysRoleUser);
        }else{
            return Results.failure();
        }
    }
}
