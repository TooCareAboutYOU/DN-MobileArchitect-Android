package com.dn.mobile_architect.lsn2.simplefactory

/**
 * @author zhangshuai
 * @date 2022/6/6 星期一
 * @email zhangshuai@dushu365.com
 * @description
 */
object SimpleFactory {

    fun create(type: Int? = 0): Api {
        return when (type) {
            1 -> {
                Impl1()
            }
            2 -> {
                Impl2()
            }
            3 -> {
                Impl3()
            }
            else -> {
                Impl()
            }
        }
    }

    /**
     * Android很少使用
     */
    fun <T : Api> createProduct(clazz: Class<T>): T {
        var api: Api? = null
        try {
            api = Class.forName(clazz.name).newInstance() as Api
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return api as T
    }

}