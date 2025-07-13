package com.hq.factory;

import com.hq.entity.Car;

import java.util.HashMap;
import java.util.Map;

// Note：静态工厂类
//       本质上就是一个集合，从集合中不断取对象，类似于池子的实现
public class StaticCarFactory {
    private static Map<Integer, Car> carMap;
    static {
        carMap = new HashMap<>();
        carMap.put(1, new Car(1, "奥迪"));
        carMap.put(2, new Car(2, "奥拓"));
    }
    public static Car getCar(Integer num) {
        return carMap.get(num);
    }
}
