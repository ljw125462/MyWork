package com.example.powermanager.service;

import com.alibaba.fastjson.JSONArray;
import com.example.powermanager.base.result.Results;
import com.example.powermanager.model.SysPermission;

public interface PermissionService {

    Results<JSONArray> listAllPermission();

    Results<SysPermission> listByRoleId(Integer intValue);
}