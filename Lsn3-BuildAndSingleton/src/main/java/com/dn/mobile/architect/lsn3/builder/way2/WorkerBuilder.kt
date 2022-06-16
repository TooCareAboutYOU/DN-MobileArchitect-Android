package com.dn.mobile.architect.lsn3.builder.way2

/**
 * @author zhangshuai
 * @date 2022/6/7 星期二
 * @email zhangshuai@dushu365.com
 * @description 生产者
 */
class WorkerBuilder : AutoCloseable {

    private val mRoomParams: WorkerBuilder.RoomParams = RoomParams()

    fun makeWindow(msg: String?): WorkerBuilder {
        mRoomParams.window = msg
        return this
    }

    fun makeFloor(msg: String?): WorkerBuilder {
        mRoomParams.floor = msg
        return this
    }

    fun build(): Room {
        return Room().apply {
            apply(mRoomParams)
        }
    }

    override fun close() {
        println("WorkerBuilder:关闭资源")
    }

    inner class RoomParams {
        var window: String? = null
        var floor: String? = null
    }
}