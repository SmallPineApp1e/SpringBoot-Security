package org.smallpineapple.springbootsecurity.controller;

import org.smallpineapple.springbootsecurity.utils.JsonResultUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zeng
 * @date 2020/2/24 22:55
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public JsonResultUtil hello(){
        return JsonResultUtil.success("成功访问公共接口", null);
    }

    @GetMapping("/db/hello")
    public JsonResultUtil db(){
        return JsonResultUtil.success("成功访问dba角色的接口", null);
    }

    @GetMapping("/admin/hello")
    public JsonResultUtil admin(){
        return JsonResultUtil.success("成功访问admin角色的接口", null);
    }

    @GetMapping("/user/hello")
    public JsonResultUtil user(){
        return JsonResultUtil.success("成功访问user角色的接口", null);
    }

}
