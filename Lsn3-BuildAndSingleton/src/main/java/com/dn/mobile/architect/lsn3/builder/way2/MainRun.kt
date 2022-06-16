package com.dn.mobile.architect.lsn3.builder.way2

/**
 * @author zhangshuai
 * @date 2022/6/7 星期二
 * @email zhangshuai@dushu365.com
 * @description 方式二
 */
object MainRun {
    @JvmStatic
    fun main(args: Array<String>) {
        val workerBuilder = WorkerBuilder().apply {
            makeFloor("修理门")
            makeWindow("修理窗户")
        }.build()
        println("输出房子信息：${workerBuilder.toString()}")

        //自动关闭资源
        try {
            WorkerBuilder().use { builder ->
                builder.makeFloor("修理门")
                builder.makeWindow("修理窗户")
                builder.build()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
}