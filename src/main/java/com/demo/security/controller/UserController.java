package com.demo.security.controller;

import com.demo.security.entity.User;
import com.demo.security.model.PageResult;
import com.demo.security.model.SimpleResult;
import com.demo.security.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private AdminService adminService;

    @GetMapping
    public ModelAndView user(){
        return new ModelAndView("user/user-list");
    }

    @GetMapping("/query/page")
    public PageResult queryUserByPage(String searchText,Pageable pageable){
        return new PageResult(adminService.queryUserPage(searchText,pageable));
    }

    @PostMapping
    public SimpleResult save(User user){
        SimpleResult result = new SimpleResult(true);
        try{
            adminService.saveUser(user);
        }catch (Exception e) {
            new SimpleResult(false);
            e.printStackTrace();
        }
        return result;
    }

}
