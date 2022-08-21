package com.ivan.feign;

import org.springframework.stereotype.Component;

/**
 * @author hylu.ivan
 * @date 2022/8/21 下午8:16
 * @description
 */
@Component
public class HelloFeignFallBack implements HelloFeign{

    @Override
    public String getCloudHello(String name) {
        return "Hello visitor the service is fallback...";
    }

    @Override
    public String getCloudPort() {
        return "fail to get port";
    }

    @Override
    public String getHystrix() {
        return "fail to get hystrix";
    }
}
