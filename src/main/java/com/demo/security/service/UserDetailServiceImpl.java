package com.demo.security.service;

import com.demo.security.entity.User;
import com.demo.security.entity.UserDetail;
import com.demo.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = userRepository.findByLoginName(s);

        if(null == user) {
            throw new UsernameNotFoundException("用户不存在");
        }

        return new UserDetail(user);
    }
}
