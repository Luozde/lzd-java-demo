package com.luozd.demo.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;


/**
 * 拦截器注册
 * 第一步：拦截器定义
 * @see JWTInterceptor
 *
 * 第二步：拦截器注册
 * 1. 实现WebMvcConfigurer接口，并通过@Configuration配置
 * 2. 注册通过方法addInterceptors实现注册指定拦截器
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Resource
    private JWTInterceptor jwtInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加拦截器，配置拦截地址
        registry.addInterceptor(jwtInterceptor).addPathPatterns("/result/**");
    }
}
