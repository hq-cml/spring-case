package com.hq;

import com.hq.repository.PeopleRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.hq.entity.People;
import java.io.InputStream;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cases c = new Cases();
        //c.Case1();
        //c.Case2();
        c.Case3();
    }
}

class Cases {
    // Note：原生接口方式
    public void Case1() {
        // Note: 加载Mybatis配置文件 & 并获取到SqlSessionFactory
        InputStream inputStream = Cases.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);

        // Note: 获取SQLSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // Note：调用Mybatis原生接口
        String statement = "com.hq.mapper.PeopleMapper.findById";
        People people = sqlSession.selectOne(statement, 1);
        System.out.println(people);

        // Note: 关闭句柄
        sqlSession.close();
    }

    // Note: Mapper代理方式
    public void Case2() {
        // Note: 加载Mybatis配置文件 & 并获取到SqlSessionFactory
        InputStream inputStream = Cases.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        // Note: 获取SQLSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // Note: 获取实现了自定义接口的代理对象
        PeopleRepository peopleRepository = sqlSession.getMapper(PeopleRepository.class);

        // Note: insert
        People people = new People();
        people.setId(3);
        people.setName("王五");
        people.setMoney(88d);
        int row =  peopleRepository.save(people);
        System.out.println(row);

        // Note: 提交事务
        sqlSession.commit();
        // Note: 关闭句柄
        sqlSession.close();
    }

    // Note: Mapper代理方式
    public void Case3() {
        // Note: 加载Mybatis配置文件 & 并获取到SqlSessionFactory
        InputStream inputStream = Cases.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        // Note: 获取SQLSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // Note: 获取实现了自定义接口的代理对象
        PeopleRepository peopleRepository = sqlSession.getMapper(PeopleRepository.class);

        // Note: findAll
        List<People> list = peopleRepository.findAll();
        for (People p: list) {
            System.out.println(p);
        }

        // Note: 关闭句柄
        sqlSession.close();
    }

}