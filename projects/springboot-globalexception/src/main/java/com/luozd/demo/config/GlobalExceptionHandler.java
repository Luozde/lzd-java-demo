package com.luozd.demo.config;

import com.luozd.demo.entity.ExceptionEnum;
import com.luozd.demo.entity.Result;
import com.luozd.demo.exception.DescribeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import com.luozd.demo.util.ResultUtil;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {


    /**
     * 判断错误是否是已定义的已知错误，不是则由未知错误代替，同时记录在log中
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result exceptionGet(Exception e) {
        log.error("【系统异常】{}", e);
        return ResultUtil.error(ExceptionEnum.UNKNOW_ERROR);
    }

    /**
     * 判断错误是否是已定义的已知错误，不是则由未知错误代替，同时记录在log中
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = DescribeException.class)
    @ResponseBody
    public Result describeException(DescribeException e) {
        return ResultUtil.error(e.getCode(), e.getMessage());
    }
}
