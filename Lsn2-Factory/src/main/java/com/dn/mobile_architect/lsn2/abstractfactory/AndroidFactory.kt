package com.dn.mobile_architect.lsn2.abstractfactory

/**
 * @author zhangshuai
 * @date 2022/6/7 星期二
 * @email zhangshuai@dushu365.com
 * @description
 */
class AndroidFactory : BaseIFactory {
    override fun create(type:Int): BaseIApi {
        //简单工厂
        when (type) {
            1 -> {
            }
            else -> {
            }
        }
        return AndroidApi()
    }
}