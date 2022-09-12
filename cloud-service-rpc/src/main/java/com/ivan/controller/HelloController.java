package com.ivan.controller;

import com.ivan.feign.HelloFeign;
import com.ivan.utils.FileUtils;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author hylu.ivan
 * @date 2022/8/21 下午8:04
 * @description
 */
@RestController
@RequestMapping("/rpc")
public class HelloController {

    @Autowired
    private HelloFeign helloFeign;

    @Value("${spring.application.name}")
    private String applicationName;

    @RequestMapping("/{name}")
    @HystrixCommand(
            threadPoolKey = "getName"
    )
    public String getName(@PathVariable String name) {

        String path = System.getProperty("user.dir") + "/"+ applicationName+"/data/1.txt";
        System.out.println(path);
        List<String> list = FileUtils.readFileByLines(path);
        System.out.println(list.size());
        return helloFeign.getCloudHello(name);
    }

    @RequestMapping("/port")
    @HystrixCommand(
            threadPoolKey = "getCloudPort"
    )
    public String getCloudPort() {
        return helloFeign.getCloudPort();
    }


    @RequestMapping("/hystrix")
    @HystrixCommand(
            threadPoolKey = "getHystrix"
    )
    public String getHystrix() {
        return helloFeign.getHystrix();
    }





}
