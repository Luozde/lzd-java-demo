package com.luozd.demo.reflection.handler;

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
public class ExceptionHandle {


    /**
     * 判断错误是否是已定义的已知错误，不是则由未知错误代替，同时记录在log中
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result exceptionGet(Exception e) {
        if (e instanceof DescribeException) {
            DescribeException MyException = (DescribeException) e;
            return ResultUtil.error(MyException.getCode(), MyException.getMessage());
        }

        log.error("【系统异常】{}", e);
        return ResultUtil.error(ExceptionEnum.UNKNOW_ERROR);
    }
}
