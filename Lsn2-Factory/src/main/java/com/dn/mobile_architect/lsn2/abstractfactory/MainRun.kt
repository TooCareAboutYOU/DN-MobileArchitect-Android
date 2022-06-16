package com.dn.mobile_architect.lsn2.abstractfactory

/**
 * @author zhangshuai
 * @date 2022/6/7 星期二
 * @email zhangshuai@dushu365.com
 * @description
 */
object MainRun {
    @JvmStatic
    fun main(args: Array<String>) {

        val androidApi = AndroidFactory().create(1)
        androidApi.show()

        val iosApi=IosFactory().create(1)
        iosApi.show()
    }
}