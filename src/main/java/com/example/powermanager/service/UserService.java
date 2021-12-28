package com.example.powermanager.service;

import com.example.powermanager.model.SysUser;

public interface UserService {
    SysUser getUser(String username);
}
