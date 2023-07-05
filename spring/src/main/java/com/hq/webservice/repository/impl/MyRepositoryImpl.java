package com.hq.webservice.repository.impl;

import com.hq.webservice.repository.MyRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component // Note: 不如专用的@Repository好
@Repository
public class MyRepositoryImpl implements MyRepository {
    @Override
    public String doRepository(Double score) {
        if (score<60) {
            return "不及格";
        } else {
            return "及格";
        }
    }
}
