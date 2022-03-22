package com.luozd.demo.controller;

import com.luozd.demo.entity.ExceptionEnum;
import com.luozd.demo.entity.Result;
import com.luozd.demo.entity.UserInfo;
import com.luozd.demo.exception.DescribeException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.luozd.demo.util.ResultUtil;

@RestController
@RequestMapping("/result")
public class ResultController {

    /**
     * 返回体测试
     *
     * @param name
     * @param pwd
     * @return
     */
    @RequestMapping(value = "/getResult", method = RequestMethod.GET)
    public Result getResult(@RequestParam("name") String name, @RequestParam("pwd") String pwd) {
        Result result = ResultUtil.success();
        if (name.equals("zzp")) {
            result = ResultUtil.success(new UserInfo());
        } else if (name.equals("pzz")) {
            result = ResultUtil.error(ExceptionEnum.USER_NOT_FIND);
        } else {
            throw new DescribeException(ExceptionEnum.UNKNOW_ERROR);
        }
        return result;
    }
}
