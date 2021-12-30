package com.example.powermanager.controller;

import com.example.powermanager.base.result.PageTableRequest;
import com.example.powermanager.base.result.Results;
import com.example.powermanager.dto.RoleDto;
import com.example.powermanager.model.SysRole;
import com.example.powermanager.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.sql.Date;
import java.text.SimpleDateFormat;

@Controller
@RequestMapping("role")
@Slf4j
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/all")
    @ResponseBody
    public Results<SysRole> getAll() {
        return roleService.getAllRoles();
    }

    @GetMapping("/list")
    @ResponseBody
    @PreAuthorize("hasAuthority('sys:role:query')")
    public Results list(PageTableRequest request) {
        log.info("RoleController.list(): param ( request = " + request +" )");
        request.countOffset();
        return roleService.getAllRolesByPage(request.getOffset(), request.getLimit());
    }

    @GetMapping(value = "/add")
    @PreAuthorize("hasAuthority('sys:role:add')")
    public String addRole(Model model) {
        model.addAttribute("sysRole",new SysRole());
        return "role/role-add";
    }

    @PostMapping(value = "/add")
    @ResponseBody
    @PreAuthorize("hasAuthority('sys:role:add')")
    public Results saveRole(@RequestBody RoleDto roleDto) {
        return roleService.save(roleDto);
    }

    @GetMapping(value = "/edit")
    public String editRole(Model model, SysRole role) {
        model.addAttribute("sysRole",roleService.getRoleById(role.getId()));
        return "role/role-edit";
    }

    @PostMapping(value = "/edit")
    @ResponseBody
    @PreAuthorize("hasAuthority('sys:role:edit')")
    public Results updateRole(@RequestBody RoleDto roleDto) {
        return roleService.update(roleDto);
    }

    @GetMapping(value = "/delete")
    @ResponseBody
    @PreAuthorize("hasAuthority('sys:role:del')")
    public Results<SysRole> deleteRole(RoleDto roleDto) {
        return roleService.delete(roleDto.getId());
    }

    String pattern = "yyyy-MM-dd";
    //只需要加上下面这段即可，注意注解
    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat(pattern), true));// CustomDateEditor为自定义日期编辑器
    }

    @GetMapping("/findRoleByFuzzyRoleName")
    @ResponseBody
    @PreAuthorize("hasAuthority('sys:role:query')")
    public Results findRoleByFuzzyRoleName(PageTableRequest requests, String roleName) {
        requests.countOffset();
        return roleService.getRoleByFuzzyRoleNamePage(roleName,requests.getOffset(),requests.getLimit());
    }

}