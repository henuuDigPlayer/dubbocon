package com.lindj.dubbo.consumer.controller;


import co.lindj.dubbo.api.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author lindj
 * @date 2018/5/4 17:02
 * @description 用户模块
 */
@RestController
@RequestMapping("/api/user")
public class UserController{

    @Reference(version = "${demo.service.version}")
    private UserService userService;

    /**
     * 获取用户数量
     *
     * @return Object
     */
    @GetMapping(value = "/list", name = "获取用户数量")
    public Object getList() {
        return this.userService.getList();
    }

}
