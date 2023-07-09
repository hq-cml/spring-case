package com.hq.repository;

import com.hq.entity.People;

import java.util.List;

// Note: 这个接口，是不需要实现类的！！！Mapper代理自动帮忙来实现！
public interface PeopleRepository {
    public int save(People people);
    public int deleteById(Integer id);
    public int update(People people);
    public People findById(Integer id);
    public List<People> findAll();
}
