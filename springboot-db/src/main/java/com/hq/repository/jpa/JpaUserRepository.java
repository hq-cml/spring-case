package com.hq.repository.jpa;

import com.hq.entity.JapUser;
import org.springframework.data.jpa.repository.JpaRepository;

// Note: 只需要继承一个接口。。。继承JpaRepository接口
//       很多方法都是继承默认有的，连方法定义都省了，需要两个泛型，分别表示实体类型和主键的类型
//       类似于o和php里面的orm都是这样的，比这个还简单
public interface JpaUserRepository extends JpaRepository<JapUser, Integer> {
    // Note：自定义一个没有的方法。。。这也很神奇，自动找到了
    public JapUser findByUsername(String name);
}
