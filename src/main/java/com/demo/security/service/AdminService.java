package com.demo.security.service;

import com.demo.security.common.TreeView;
import com.demo.security.entity.Role;
import com.demo.security.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sun.reflect.generics.tree.Tree;

import java.util.List;
import java.util.Map;

public interface AdminService {

    User saveUser(User user);

    Role saveRole(Role role);

    Page<User> queryUserPage(String searchText, Pageable pageable);

    List<Role> queryRole();

    List<TreeView> queryRoleTree();

    Page<Role> queryRolePage(String searchText,Pageable pageable);
}
