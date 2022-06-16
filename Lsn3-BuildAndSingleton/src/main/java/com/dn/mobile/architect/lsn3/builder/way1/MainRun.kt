package com.dn.mobile.architect.lsn3.builder.way1


/**
 * @author zhangshuai
 * @date 2022/6/7 星期二
 * @email zhangshuai@dushu365.com
 * @description 方式一
 */
object MainRun {
    @JvmStatic
    fun main(args: Array<String>) {
        val workerBuilder = WorkerBuilder()
        workerBuilder.makeFloor("修建门")
        workerBuilder.makeWindow("修建窗户")

        val room = Designer.build(workerBuilder)
        println("窗户：${room?.window}, 门：${room?.floor}")
    }
}