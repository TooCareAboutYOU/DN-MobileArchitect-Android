package com.dn.mobile.architect.lsn3.builder.way1

/**
 * @author zhangshuai
 * @date 2022/6/7 星期二
 * @email zhangshuai@dushu365.com
 * @description 设计者
 */
object Designer {

    @JvmStatic
    fun build(builder: Builder): Room? {
        builder.makeWindow()
        builder.makeFloor()
        return builder.build()
    }
}