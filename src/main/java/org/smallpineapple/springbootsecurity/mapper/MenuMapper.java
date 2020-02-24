package org.smallpineapple.springbootsecurity.mapper;

import org.smallpineapple.springbootsecurity.bean.Menu;

import java.util.List;

/**
 * @author Zeng
 * @date 2020/2/24 23:14
 */
public interface MenuMapper {

    List<Menu> findAllMenusWithRoles();


}
