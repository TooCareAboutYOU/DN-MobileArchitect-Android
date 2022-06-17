package com.dn.mobile.architect.lsn5.db

/**
 * @author zhangshuai
 * @date 2022/6/15 星期三
 * @email zhangshuai@dushu365.com
 * @description 规范所有的数据库操作
 */
interface IBaseDao<T> {
    fun insert(entity: T): Long?

    fun update(entity: T, where: T): Long

    fun delete(where: T): Int
//
//    fun query(where: T): List<T>
//    fun query(where: T, orderBy: String, startIndex: Int, limit: Int): List<T>
//    fun query(sql: String): List<T>
}