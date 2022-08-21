package com.ivan.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hylu.ivan * @date 2022/8/21 下午7:44
 * @description
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/{name}")
    public String getCloudHello(@PathVariable String name) {
        return "Hello " + name;
    }
}
