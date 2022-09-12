package com.ivan.controller;

import com.ivan.model.HelloInject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hylu.ivan * @date 2022/8/21 下午7:44
 * @description
 */
@RestController
@RequestMapping("/demo")
public class HelloController {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/{name}")
    public String getCloudHello(@PathVariable String name) {

        HelloInject helloInject = new HelloInject();
        return "Hello " + name;
    }

    @RequestMapping("/port")
    public String getCloudLocation() {
        return port;
    }

    @RequestMapping("/hystrix")
    public String getHystrix() {
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return port;
    }


}
