package com.hq.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor // 带餐构造
public class Car {
    private Integer num;
    private String brand;
}
