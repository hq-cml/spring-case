package com.hq.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Data
@Component // Note: 添加这个注解，才能自动装载进Ioc，装载进去id是首字母小写的类名repository
//@Component(value = "new_name") // Note: 不使用默认名字，自己指定名字
public class Repository {
    @Autowired // Note: @Autowired就相当于spring.xml中的ref！！
    //@Qualifier(value="mySource") // Note：按照ByName而不是默认的ByType来自动注入
    private DataSource dataSource;
}
