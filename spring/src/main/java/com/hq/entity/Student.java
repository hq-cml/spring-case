package com.hq.entity;

import lombok.Data;

@Data // Note：默认给到无参构造
public class Student {
    private Integer id;
    private String name;
    private  Integer age;
}
