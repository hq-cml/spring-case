package com.hq.service.impl;

import com.hq.entity.User;
import com.hq.repository.UserRepository;
import com.hq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    //@Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
