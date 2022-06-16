package com.dn.mobile.architect.lsn3.builder.way1

/**
 * @author zhangshuai
 * @date 2022/6/7 星期二
 * @email zhangshuai@dushu365.com
 * @description 抽象建造者
 *
 */
interface Builder {

    fun makeWindow(msg: String? = null)

    fun makeFloor(msg: String? = null)

    fun build(): Room?
}