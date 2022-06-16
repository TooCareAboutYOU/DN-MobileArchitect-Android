package com.dn.mobile_architect.lsn2.methodfactory

/**
 * @author zhangshuai
 * @date 2022/6/7 星期二
 * @email zhangshuai@dushu365.com
 * @description 【工厂方法模式】
 * 定义：定义个用于创建对象的接口，让子类决定实例化哪一个类，工厂方法使一个类的实例化延迟到创建器的子类中
 * 好处：
 *  1、父类中增加操作，子类可直接复用
 *  2、
 */
object MainRun {

    @JvmStatic
    fun main(args: Array<String>) {
        val operator: BaseExportOperator = ExportTextOperator()
        operator.export("我是导出的数据")
    }
}