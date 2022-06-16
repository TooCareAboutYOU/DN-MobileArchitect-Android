package com.dn.mobile.architect.lsn4.prototype

/**
 * @author zhangshuai
 * @date 2022/6/8 星期三
 * @email zhangshuai@dushu365.com
 * @description 原型模式
 * 1、定义：用原型的实例指定创建的种类，并通过拷贝这些原型创建新的对象
 * 2、目的：保护原始的那一份存档，隐藏复制的过程
 *
 */
object MainRun {

    @JvmStatic
    fun main(args: Array<String>) {
        val factory = OrderDealFactory()
        val order = PersonOrder().apply {
            setOrderName("生成的产品")
            setOrderNumber(3200)
        }
        factory.dealOrder(order)
    }
}