package com.hq.service.impl;

import com.hq.entity.User;
import com.hq.reposity.UserRepository;
import com.hq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Collection<User> findAll() {
        return userRepository.findAll();
    }
    @Override
    public User findById(Integer id) {
        return userRepository.findById(id);
    }
    @Override
    public void save(User user) {
        userRepository.save(user);
    }
    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }
    @Override
    public void update(User user) {
        userRepository.update(user);
    }
}
