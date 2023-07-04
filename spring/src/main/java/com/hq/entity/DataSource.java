package com.hq.entity;

import lombok.Data;

@Data
public class DataSource {
    private String user;
    private String url;
    private String password;
    private String driverName;
}
