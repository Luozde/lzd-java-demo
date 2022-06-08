package com.luozd.demo.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.luozd.demo.entity.ExceptionEnum;
import com.luozd.demo.entity.Result;
import com.luozd.demo.exception.DescribeException;
import com.luozd.demo.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
@Component
public class GlobalExceptionTest implements HandlerExceptionResolver {

    @Resource
    ObjectMapper objectMapper;

    /**
     * TODO 简单描述该方法的实现功能（可选）.
     *
     * @see org.springframework.web.servlet.HandlerExceptionResolver#resolveException(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
     */
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
                                         Exception ex) {
        response.setContentType("application/json");
        Result result;
        PrintWriter out = null;
        try {
            out = response.getWriter();
            if (ex instanceof DescribeException) {
                DescribeException ex1 = (DescribeException) ex;
                result = ResultUtil.error(ex1.getCode(), ex1.getMessage());
                log.error("全局错误：", ex1.getMessage());
            } else {
                result = ResultUtil.error(ExceptionEnum.UNKNOW_ERROR);
                log.error("全局错误：", ExceptionEnum.UNKNOW_ERROR);
            }

            out.append(objectMapper.writeValueAsString(result));
            response.setHeader("Access-Control-Allow-Origin","*");
        } catch (IOException e1) {
            log.error("全局错误：", e1);
        } finally {
            if (out != null) {
                out.flush();
                out.close();
            }
        }
        return new ModelAndView();
    }
}
