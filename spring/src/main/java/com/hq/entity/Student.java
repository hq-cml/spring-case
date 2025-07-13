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
    private Classes classes; // Note：DI注入

    // Note: 自己实现无参构造，所以@NoArgsConstructor必须注销掉，否则报错
    public Student() {
        System.out.println("无参构造创建Student");
    }
}
