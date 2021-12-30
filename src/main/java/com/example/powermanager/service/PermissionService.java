package com.example.powermanager.service;

import com.alibaba.fastjson.JSONArray;
import com.example.powermanager.base.result.Results;
import com.example.powermanager.model.SysPermission;

import java.util.List;

public interface PermissionService {

    Results<JSONArray> listAllPermission();

    Results<SysPermission> listByRoleId(Integer intValue);

    Results<SysPermission> getMenuAll();

    Results<SysPermission> save(SysPermission sysPermission);

    SysPermission getSysPermissionById(Integer id);

    Results  updateSysPermission(SysPermission sysPermission);

    Results delete(Integer id);
    List<SysPermission> getMenu();

    Results<SysPermission> getMenu(Long userId);
}