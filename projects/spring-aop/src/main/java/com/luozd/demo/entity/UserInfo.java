package com.luozd.demo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @业务描述：
 * @package_name： com.ratel.com.luozd.demo.exception.com.luozd.demo.entity
 * @project_name： global-com.luozd.demo.exception
 * @author： ratelfu@qq.com
 * @create_time： 2019-11-14 14:36
 * @copyright (c) ratelfu 版权所有
 */
@Data
public class UserInfo implements Serializable {
    private String name;
    private Integer age;

    public UserInfo() {
    }

    public UserInfo(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
