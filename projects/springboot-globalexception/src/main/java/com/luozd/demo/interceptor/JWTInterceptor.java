package com.luozd.demo.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 第一步：拦截器定义
 * 要点：
 * 1. 实现HandlerInterceptor接口；
 * 2. 注入bean容器；
 *
 * 第二步：拦截器注册生效
 * @see WebConfig
 */
@Component
public class JWTInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取请求头中令牌
        System.out.println("hello world!");
        return true;
    }
}
