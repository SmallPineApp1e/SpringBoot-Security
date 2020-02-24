package org.smallpineapple.springbootsecurity;

import org.junit.jupiter.api.Test;
import org.smallpineapple.springbootsecurity.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootSecurityApplicationTests {
    @Autowired
    MenuService menuService;

    @Test
    void contextLoads() {
        System.out.println(menuService.findAllMenusWithRoles());
    }

}
