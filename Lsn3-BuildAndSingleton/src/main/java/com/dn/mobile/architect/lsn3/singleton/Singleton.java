package com.dn.mobile.architect.lsn3.singleton;

import java.net.PortUnreachableException;

/**
 * @author zhangshuai
 * @date 2022/6/8 星期三
 * @email zhangshuai@dushu365.com
 * @description
 */
class Singleton {
    /**
     * 饿汉式
     * 不可传参
     */
    public static class Singleton1 {
        private static final Singleton1 singleton1 = new Singleton1();

        private Singleton1() {}

        public static Singleton1 getInstance() {
            return singleton1;
        }
    }

    /**
     * 懒汉式
     * 可传参
     * 多线程可能被开辟出多个对象
     */
    public static class Singleton2 {
        private static Singleton2 singleton2 = null;

        private Singleton2() {}

        public static Singleton2 getInstance() {
            if (singleton2 == null) {
                singleton2 = new Singleton2();
            }
            return singleton2;
        }
    }

    /**
     * 双重锁检测
     * 虚拟机，寄存器主存。若出现多个CPU操作，singleton3会被拷贝副本到多个CPU内存中
     * volatile 不产生副本，
     * 1、保证在多个线程中对这个变量进行操作时的可见性，即一个线程修改了某个变量的值，这个新值对其他线程来说是立即可见的
     * 2、禁止进行指令重排
     */
    public static class Singleton3 {
        //线程并发时，当变量改动了，所有线程都能及时访问到最新的数据，会屏蔽掉虚拟机的衣袖代码优化
        private static volatile Singleton3 singleton3 = null;

        private Singleton3() {}

        public static Singleton3 getInstance() {
            if (singleton3 == null) {
                synchronized (Singleton3.class) {
                    if (singleton3 == null) {
                        singleton3 = new Singleton3();
                    }
                }
            }
            return singleton3;
        }
    }

    /**
     * 静态内部类
     * 既能延迟加载，又能实现线程安全
     *
     *
     */
    public static class Singleton4 {

        public Singleton4(){

        }

        private static class InnerClass {
            //静态内部类的静态属性实例化的时候，有JVM虚拟机保证线程安全
            public static Singleton4 holder = new Singleton4();
        }

        public static Singleton4 getInstance() {
            return InnerClass.holder;
        }
    }

    /**
     * 枚举单例
     */

    public enum MyEnum{
        RED(1,"红色"),
        BULE(2,"蓝色");
        private int index;
        private String name;

        MyEnum(final int mIndex, final String mName) {
            index = mIndex;
            name = mName;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(final int mIndex) {
            index = mIndex;
        }

        public String getName() {
            return name;
        }

        public void setName(final String mName) {
            name = mName;
        }
    }

    private enum Singleton5{
        instance;
        public void print(){
            System.out.println("处理中。。。。。");
        }
    }

    public static void main(String[] args) {
        MyEnum.RED.setName("修改后的颜色：黑色");
        System.out.println("枚举打印："+MyEnum.BULE.getName()+"，"+MyEnum.RED.getName());

        Singleton5.instance.print();
    }



}
