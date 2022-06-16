package com.dn.mobile_architect.lsn2.methodfactory

/**
 * @author zhangshuai
 * @date 2022/6/7 星期二
 * @email zhangshuai@dushu365.com
 * @description
 */
abstract class BaseExportOperator {

    //工厂方法：核心就是延迟到了子类实例化
    abstract fun factoryMethod(): BaseExportFileApi

    /**
     * 导出文件
     * @param data 需要导出的数据
     * @return 是否成功
     */
    fun export(data: String?): Boolean {
        val api: BaseExportFileApi = factoryMethod()
        api.printData(data)
        return api.export(data)
    }
}