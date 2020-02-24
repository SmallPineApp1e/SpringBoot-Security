package org.smallpineapple.springbootsecurity.mapper;

import org.smallpineapple.springbootsecurity.bean.Role;
import org.smallpineapple.springbootsecurity.bean.User;

import java.util.List;

/**
 * @author Zeng
 * @date 2020/2/24 22:41
 */
public interface UserMapper {
    User loadUserByUsername(String s);

    List<Role> findRolesByUserId(Integer id);
}
