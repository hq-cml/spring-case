package com.hq.repository.mybatis;

import com.hq.entity.User;

import java.util.List;

// Note: Mybatis的牛逼之处在于不需要实现类，只需要接口
public interface UserRepository {
    public List<User> findAll();
    public User findById(Integer id);
    public int save(User user);
    public int update(User user);
    public int deleteById(Integer id);
}

