package com.ivan.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author hylu.ivan
 * @date 2022/8/21 下午8:14
 * @description
 */
@FeignClient(name = "cloud-service-demo",fallback = HelloFeignFallBack.class)
public interface HelloFeign {

    @RequestMapping("/demo/{name}")
    public String getCloudHello(@PathVariable String name);

    @RequestMapping("/demo/port")
    public String getCloudPort();

    @RequestMapping("/demo/hystrix")
    public String getHystrix();
}
