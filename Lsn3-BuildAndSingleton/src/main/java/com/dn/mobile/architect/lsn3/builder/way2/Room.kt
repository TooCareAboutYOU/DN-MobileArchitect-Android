package com.dn.mobile.architect.lsn3.builder.way2

/**
 * @author zhangshuai
 * @date 2022/6/7 星期二
 * @email zhangshuai@dushu365.com
 * @description
 */
class Room {

    private var window: String? = null
    private var floor: String? = null


    fun apply(params: WorkerBuilder.RoomParams?) {
        this.window = params?.window
        this.floor = params?.floor
    }

    override fun toString(): String {
        return "Room(window=$window, floor=$floor)"
    }
}