package com.dn.mobile_architect.lsn2.simplefactory

/**
 * @author zhangshuai
 * @date 2022/6/6 星期一
 * @email zhangshuai@dushu365.com
 * @description 【简单工厂模式】
 */
class MainRun {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            //简单工厂模式：
            //最少知识原则
            val api=SimpleFactory.create(1)
            api.operator()

            val api1=SimpleFactory.createProduct(Impl2::class.java)
            api1.operator()

        }
    }
}