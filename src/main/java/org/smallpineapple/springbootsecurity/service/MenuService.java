package org.smallpineapple.springbootsecurity.service;

import org.smallpineapple.springbootsecurity.bean.Menu;
import org.smallpineapple.springbootsecurity.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Zeng
 * @date 2020/2/24 23:13
 */
@Service
public class MenuService {
    @Autowired
    MenuMapper menuMapper;

    public List<Menu> findAllMenusWithRoles(){
        List<Menu> menus = menuMapper.findAllMenusWithRoles();
        return menus;
    };

}
