package com.meituan.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 注解
 * author: qiushi
 * date  : 2017/10/27
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    public String message() {
        return "hello";
    }
}
