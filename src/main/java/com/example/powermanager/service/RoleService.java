package com.example.powermanager.service;

import com.example.powermanager.base.result.Results;
import com.example.powermanager.dto.RoleDto;
import com.example.powermanager.model.SysRole;


public interface RoleService {
    Results<SysRole> getAllRoles();

    Results<SysRole> getAllRolesByPage(Integer offset, Integer limit);

    Results<SysRole> save(RoleDto roleDto);

    SysRole getRoleById(Integer id);

    Results update(RoleDto roleDto);

    Results delete(Integer id);

    Results<SysRole> getRoleByFuzzyRoleNamePage(String roleName, Integer offset, Integer limit);
}
