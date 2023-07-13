package com.hq.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "t_user") // Note: 映射表名
public class JapUser {
    @Id // Note: 映射主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Note: 自动生成主键，strategy表示主键生成策略
    private Integer id;
    @Column // Note:普通字段映射
    private String username;
    @Column
    private String password;
    @Column
    private Integer age;
}
