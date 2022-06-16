package com.dn.mobile_architect.lsn2.abstractfactory

/**
 * @author zhangshuai
 * @date 2022/6/7 星期二
 * @email zhangshuai@dushu365.com
 * @description 生产Api
 */
interface BaseIFactory {
    fun create(type:Int): BaseIApi
}