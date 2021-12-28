package com.example.powermanager.controller;

import com.example.powermanager.base.result.Results;
import com.example.powermanager.model.SysUser;
import com.example.powermanager.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
@RequestMapping("user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{username}")
    @ResponseBody
    public SysUser user(@PathVariable String username)
    {
        log.info("UserController.user():param ( username = "+username+")");
        return userService.getUser(username);
    }

    @GetMapping("/list")
    @ResponseBody
    public Results<SysUser> list()
    {
        ArrayList<SysUser> list = new ArrayList<SysUser>();
        list.add(userService.getUser("admin"));
        return Results.success("success",100,list);
    }
}
