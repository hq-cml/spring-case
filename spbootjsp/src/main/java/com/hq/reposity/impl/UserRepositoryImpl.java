package com.hq.reposity.impl;

import com.hq.entity.User;
import com.hq.reposity.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private static Map<Integer, User> map;
    static {
        map = new HashMap<>();
        map.put(1,new User(1,"张三"));
        map.put(2,new User(2,"李四"));
        map.put(3,new User(3,"王五"));
    }
    @Override
    public Collection<User> findAll() {
        return map.values();
    }
    @Override
    public User findById(Integer id) {
        return map.get(id);
    }
    @Override
    public void save(User user) {
        map.put(user.getId(),user);
    }
    @Override
    public void deleteById(Integer id) {
        map.remove(id);
    }
    @Override
    public void update(User user) {
        map.put(user.getId(),user);
    }
}
