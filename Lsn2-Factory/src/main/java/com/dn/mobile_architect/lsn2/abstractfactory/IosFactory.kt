package com.dn.mobile_architect.lsn2.abstractfactory

/**
 * @author zhangshuai
 * @date 2022/6/7 星期二
 * @email zhangshuai@dushu365.com
 * @description
 */
class IosFactory : BaseIFactory {
    override fun create(type:Int): BaseIApi {
        return IosApi()
    }
}