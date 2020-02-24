package org.smallpineapple.springbootsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zeng
 * @date 2020/2/24 22:55
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/db/hello")
    public String db(){
        return "/db/hello";
    }

    @GetMapping("/admin/hello")
    public String admin(){
        return "/admin/hello";
    }

    @GetMapping("/user/hello")
    public String user(){
        return "/user/hello";
    }


}
