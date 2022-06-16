package com.dn.mobile_architect.lsn2.methodfactory

/**
 * @author zhangshuai
 * @date 2022/6/7 星期二
 * @email zhangshuai@dushu365.com
 * @description 当初数据文件(exp：数据库文件、文本、XML、Excel等等)
 */
interface BaseExportFileApi {
    /**
     * 导出文件
     * @param data 需要导出的数据
     * @return 是否成功
     */
    fun export(data: String?): Boolean

    //后续扩展
    fun printData(input: String?) {
        println("ExportFileApi::printData():打印数据：$input")
    }
}