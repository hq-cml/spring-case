package com.hq.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
//@Component("mySource") // Note：确保能够被注入Ioc，且id用指定名字
@Component // Note：确保能够被注入Ioc
public class DataSource {
    @Value("root") // Note: @Value用来赋初值的，相当于spring.xml中的property标签，或者说是constructor-arg标签
    private String user;
    @Value("aaa")
    private String url;
    @Value("bbb")
    private String password;
    @Value("ccc")
    private String driverName;
}
