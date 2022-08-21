package com.ivan.controller;

import com.ivan.feign.HelloFeign;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hylu.ivan
 * @date 2022/8/21 下午8:04
 * @description
 */
@RestController
@RequestMapping("/helloRpc")
public class HelloController {

    @Autowired
    private HelloFeign helloFeign;

    @RequestMapping("/{name}")
    @HystrixCommand(
            threadPoolKey = "getName"
    )
    public String getName(@PathVariable String name) {
        return helloFeign.getCloudHello(name);
    }
}
