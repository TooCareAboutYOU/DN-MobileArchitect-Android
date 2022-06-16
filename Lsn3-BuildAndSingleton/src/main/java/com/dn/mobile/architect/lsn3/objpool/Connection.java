package com.dn.mobile.architect.lsn3.objpool;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangshuai
 * @date 2022/6/8 星期三
 * @email zhangshuai@dushu365.com
 * @description 、
 * 对象池：控制对象的个数
 */
class Connection {
    //假设只有5个对象
    private static final int max = 5;

    //把所有对象先存到一个map中
    private static Map<Integer, Connection> map = new HashMap<>();

    private static int key = 1;

    public static Connection getInstance() {
        Connection instance = map.get(key);
        if (instance == null) {
            instance = new Connection();
            map.put(key, instance);
        }
        key++;
        if (key > max) {
            key = 1;
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 200; i++) {
            System.out.println("打印："+Connection.getInstance()+", "+System.currentTimeMillis());
        }
    }
}
