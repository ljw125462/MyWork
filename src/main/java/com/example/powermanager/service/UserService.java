package com.example.powermanager.service;

import com.example.powermanager.base.result.Results;
import com.example.powermanager.dto.UserDto;
import com.example.powermanager.model.SysUser;

public interface UserService {
    SysUser getUser(String username);

    Results<SysUser> getAllUsersByPage(Integer offset, Integer limit);

    Results<SysUser> save(SysUser userDto, Integer roleId);

    SysUser getUserByPhone(String telephone);

    SysUser getUserById(Long id);

    Results<SysUser> updateUser(UserDto userDto, Integer roleId);

    int deleteUser(Long id);

    Results<SysUser> getUserByFuzzyUsername(String username, Integer offset, Integer limit);
}
