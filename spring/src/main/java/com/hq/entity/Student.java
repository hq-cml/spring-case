package com.hq.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Note：默认给到无参构造
@AllArgsConstructor // Note：给到全参构造，但是会顶掉无参构造
//@NoArgsConstructor // Note: 给到无参构造，因为默认无参被顶掉了
public class Student {
    private Integer id;
    private String name;
    private  Integer age;
    private Classes classes; // Note：注入

    public Student() {
        System.out.println("无参构造创建Student");
    }
}
