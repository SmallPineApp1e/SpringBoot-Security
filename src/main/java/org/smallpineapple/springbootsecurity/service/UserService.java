package org.smallpineapple.springbootsecurity.service;

import org.smallpineapple.springbootsecurity.bean.User;
import org.smallpineapple.springbootsecurity.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Zeng
 * @date 2020/2/24 22:42
 */
@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userMapper.loadUserByUsername(s);
        if(user == null){
            throw new UsernameNotFoundException("用户不存在!");
        }
        user.setRoles(userMapper.findRolesByUserId(user.getId()));
        return user;
    }

}
