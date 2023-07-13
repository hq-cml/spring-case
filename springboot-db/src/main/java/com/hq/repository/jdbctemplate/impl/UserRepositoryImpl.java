package com.hq.repository.jdbctemplate.impl;

import com.hq.entity.User;
import com.hq.repository.jdbctemplate.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

// 实现类
@Repository
public class UserRepositoryImpl implements UserRepository {
    // Note: 框架自带的，直接注入
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query(
                "select * from t_user",
                new BeanPropertyRowMapper<>(User.class) // Note: 将结果集转换成对应的类对象
        );
    }

    @Override
    public User findById(Integer id) {
        return jdbcTemplate.queryForObject(
                "select * from t_user where id=?",
                new Object[]{id},
                new BeanPropertyRowMapper<>(User.class) // Note: 将结果集转换成对应的类对象
        );
    }

    @Override
    public int save(User user) {
        return jdbcTemplate.update(
                "insert into t_user(username, password, age) values(?, ?, ?)",
                user.getUsername(),
                user.getPassword(),
                user.getAge()
        );
    }

    @Override
    public int update(User user) {
        return jdbcTemplate.update(
                "update t_user set username =?, password=?, age=? where id=?",
                user.getUsername(),
                user.getPassword(),
                user.getAge(),
                user.getId()
        );
    }

    @Override
    public int deleteById(Integer id) {
        return jdbcTemplate.update(
                "delete from t_user where id=?",
                id
        );
    }
}
