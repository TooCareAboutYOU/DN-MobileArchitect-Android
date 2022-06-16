package com.dn.mobile.architect.lsn4.prototype

/**
 * @author zhangshuai
 * @date 2022/6/8 星期三
 * @email zhangshuai@dushu365.com
 * @description
 */
class PersonOrder : IOrder {
    private var orderName: String? = null
    private var orderNumber: Int = -1

    override fun getOrderNumber(): Int {
        return orderNumber
    }

    override fun setOrderNumber(number: Int) {
        this.orderNumber = number
    }

    fun setOrderName(name: String? = null) {
        this.orderName = name
    }

    fun getOrderName() = this.orderName

    override fun clonePrototype(): Prototype {
        return PersonOrder().apply {
            setOrderName(orderName)
            setOrderNumber(orderNumber)
        }
    }
}