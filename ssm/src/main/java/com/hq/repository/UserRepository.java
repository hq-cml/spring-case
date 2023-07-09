package com.hq.repository;

import com.hq.entity.User;

import java.util.List;

public interface UserRepository {
    public List<User> findAll();
}
