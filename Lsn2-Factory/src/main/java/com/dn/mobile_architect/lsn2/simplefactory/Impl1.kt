package com.dn.mobile_architect.lsn2.simplefactory

/**
 * @author zhangshuai
 * @date 2022/6/6 ζζδΈ
 * @email zhangshuai@dushu365.com
 * @description
 */
class Impl1 : Api {
    override fun operator() {
        println("${this.javaClass.simpleName}::operator()")
    }
}