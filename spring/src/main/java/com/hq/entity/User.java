package com.hq.entity;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String name;

    public User() {
        System.out.println("无参构造生成User");
    }
}
