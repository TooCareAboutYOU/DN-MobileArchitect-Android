package com.dn.mobile_architect.lsn2.methodfactory

/**
 * @author zhangshuai
 * @date 2022/6/7 星期二
 * @email zhangshuai@dushu365.com
 * @description
 */
class ExportTextFile : BaseExportFileApi {
    /**
     * 导出文件
     * @param data 需要导出的数据
     * @return 是否成功
     */
    override fun export(data: String?): Boolean {
        println("ExportTextFile::export():数据：$data")
        println("ExportTextFile::export():到处生成的文本文件")
        return false
    }
}