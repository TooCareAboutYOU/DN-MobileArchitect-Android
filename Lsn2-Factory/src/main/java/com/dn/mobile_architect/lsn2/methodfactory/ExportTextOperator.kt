package com.dn.mobile_architect.lsn2.methodfactory

/**
 * @author zhangshuai
 * @date 2022/6/7 ζζδΊ
 * @email zhangshuai@dushu365.com
 * @description
 */
class ExportTextOperator : BaseExportOperator() {
    override fun factoryMethod(): BaseExportFileApi {
        return ExportTextFile()
    }
}