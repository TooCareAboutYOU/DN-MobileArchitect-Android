package com.dn.mobile.architect.lsn3.builder.way1

/**
 * @author zhangshuai
 * @date 2022/6/7 星期二
 * @email zhangshuai@dushu365.com
 * @description 生产者
 */
class WorkerBuilder : Builder {

    private val room: Room = Room()

    override fun makeWindow(msg: String?) {
        room.window = msg
    }

    override fun makeFloor(msg: String?) {
        room.floor = msg
    }

    override fun build(): Room {
        return room
    }



}