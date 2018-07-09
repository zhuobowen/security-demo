package com.demo.security.controller;

import com.demo.security.service.AdminService;
import net.minidev.json.JSONArray;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleControllerTest {

    @Autowired
    private AdminService adminService;

    @Test
    public void test(){
        System.out.println(JSONArray.toJSONString(adminService.queryRoleTree()));
    }
}
