package com.dn.mobile.architect.lsn3.builder.way2;

/**
 * @author zhangshuai
 * @date 2022/6/7 ζζδΊ
 * @email zhangshuai@dushu365.com
 * @description
 */
class Main {
    public static void main(String[] args) {
        try (WorkerBuilder builder = new WorkerBuilder()) {
            builder.build();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
