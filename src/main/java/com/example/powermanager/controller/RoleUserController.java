package com.example.powermanager.controller;

import com.example.powermanager.base.result.Results;
import com.example.powermanager.service.RoleUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("roleuser")
@Slf4j
public class RoleUserController {

    @Autowired
    private RoleUserService roleUserService;

    @PostMapping("/getRoleUserByUserId")
    public Results getRoleUserByUserId(Integer userId) {
        log.info("getRoleUserByUserId（"+userId+"）");
        return roleUserService.getSysRoleUserByUserId(userId);
    }
}
