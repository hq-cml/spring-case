package com.hq;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.hq.entity.People;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        // Note: 加载Mybatis配置文件 & 并获取到SqlSessionFactory
        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("config.xml");
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
}