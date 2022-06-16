package com.dn.mobile.architect.lsn4.prototype

/**
 * @author zhangshuai
 * @date 2022/6/8 星期三
 * @email zhangshuai@dushu365.com
 * @description
 */
class OrderDealFactory {

    fun dealOrder(order: IOrder?) {
        order?.apply {
            var number = this.getOrderNumber()
            while (number > 0) {
                println("原始订单信息：${order.hashCode()}")
                //方式一
//                val personOrder = order as PersonOrder
//                val newOrder = PersonOrder()
//                newOrder.setOrderName(personOrder.getOrderName())
//                newOrder.setOrderNumber(if (number >= 1000) 1000 else number)
//                println("打印新订单信息：${newOrder.hashCode()}, 剩余处理订单：$number")
//                number -= 1000

                //方式二：原型模式
                val iOrder = order.clonePrototype() as IOrder
                iOrder.setOrderNumber(if (number >= 1000) 1000 else number)
                println("打印新订单信息：${iOrder.hashCode()}, 剩余处理订单：$number")
                number -= 1000
            }
        }

    }

}