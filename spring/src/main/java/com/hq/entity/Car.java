package com.hq.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor // 带餐构造
@NoArgsConstructor
public class Car {
    private Integer num;
    private String brand;
}
