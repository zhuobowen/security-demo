package com.demo.security.service.impl;

import com.demo.security.common.TreeView;
import com.demo.security.entity.Role;
import com.demo.security.entity.User;
import com.demo.security.repository.AuthorityRepository;
import com.demo.security.repository.RoleRepository;
import com.demo.security.repository.UrlRepository;
import com.demo.security.repository.UserRepository;
import com.demo.security.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.management.relation.RoleList;
import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private UrlRepository urlRepository;

    @Override
    public User saveUser(User user) {
        if(user != null && StringUtils.isEmpty(user.getId())){
            user.setIsOnline(false);
            user.setCreateTime(new Date());
        }
        return userRepository.saveAndFlush(user);
    }

    @Override
    public Role saveRole(Role role) {
        if(role != null && role.getParent()!= null){
            Role parent = roleRepository.findOne(role.getParent().getId());
            role.setParent(parent);
        }
        return roleRepository.saveAndFlush(role);
    }

    @Override
    public Page<User> queryUserPage(String searchText, Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public List<TreeView> queryRoleTree() {
        List<Role> roles = roleRepository.findAll();
        Map<String,Object> nodeMap = null;
        List<TreeView> list = new ArrayList<TreeView>();
        TreeView treeView = null;
        //先找一级角色
        Iterator<Role> it = roles.iterator();
        while ( it.hasNext() ){
            Role root = it.next();
            if(root != null && root.getParent() == null) {
                treeView = new TreeView();
                treeView.setId(root.getId());
                treeView.setText(root.getRemark());
                treeView.setParentId(null);
                treeView.setNodes(getChild(treeView,roles));
                list.add(treeView);
            }
        }
        return list;
    }

    private List<TreeView> getChild(TreeView root,List<Role> roles){
        List<TreeView> list = null;
        TreeView treeView = null;
        for(Role role : roles){
            if(role.getParent() != null && (role.getParent().getId()).equals(root.getId())){
                list = new ArrayList<TreeView>();
                treeView = new TreeView();
                treeView.setId(role.getId());
                treeView.setText(role.getRemark());
                treeView.setParentId(root.getId());
                treeView.setNodes(getChild(treeView,roles));
                list.add(treeView);
            }
        }
        root.setNodes(list);
        return list;
    }

    @Override
    public List<Role> queryRole() {
        return roleRepository.findAll();
    }

    @Override
    public Page<Role> queryRolePage(String searchText,Pageable pageable) {
        return roleRepository.findByNameLikeOrRemarkLike(searchText,searchText,pageable);
    }
}
