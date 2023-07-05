package com.hq.webservice.service.impl;

import com.hq.webservice.repository.MyRepository;
import com.hq.webservice.service.MyService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Data
//@Component //Note: 不如专用的@Service好
@Service
public class MyServiceImpl implements MyService {
    @Autowired
    private MyRepository myRepository;
    @Override
    public String doService(Double score) {
        return myRepository.doRepository(score);
    }
}
