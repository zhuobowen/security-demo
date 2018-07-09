package com.demo.security.controller;

import com.demo.security.common.TreeView;
import com.demo.security.entity.Role;
import com.demo.security.model.SimpleResult;
import com.demo.security.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private AdminService adminService;

    @GetMapping
    public ModelAndView role(){
        return new ModelAndView("role/role-list");
    }

    @GetMapping("tree")
    public List<TreeView> tree(){
        return adminService.queryRoleTree();
    }

    @GetMapping("/list")
    public List<Role> list(){
        return adminService.queryRole();
    };

    @GetMapping("/page")
    public Map<String,Object> page(String searchText, Pageable pageable){
        Map<String,Object> resultMap = new HashMap<String,Object>();
        Page<Role> page = adminService.queryRolePage(searchText,pageable);
        resultMap.put("rows",page.getContent());
        resultMap.put("total",page.getTotalElements());
        return resultMap;
    }

    @PostMapping
    public SimpleResult save(Role role){
        SimpleResult simpleResult = null;
        try{
            adminService.saveRole(role);
            simpleResult = new SimpleResult(true);
        }catch (Exception e){
            e.printStackTrace();
            simpleResult = new SimpleResult(false);
        }
        return simpleResult;
    }
}
