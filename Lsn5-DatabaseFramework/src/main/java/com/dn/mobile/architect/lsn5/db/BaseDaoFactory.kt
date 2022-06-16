package com.dn.mobile.architect.lsn5.db

import android.database.sqlite.SQLiteDatabase

/**
 * @author zhangshuai
 * @date 2022/6/15 星期三
 * @email zhangshuai@dushu365.com
 * @description
 */
class BaseDaoFactory {

    companion object {
        @JvmStatic
        private val ourInstance = BaseDaoFactory()

        @JvmStatic
        fun getOurInstance(): BaseDaoFactory {
            return ourInstance
        }
    }

    //定义建数据库的路径
    //建议写在SD卡中，优点：APP被删除了下次安装的时候，数据还在。
    private val sqlLiteDatabasePath: String = "data/data/com.dn.mobile.architect.lsn5/test.db"

    private var sqlSQLiteDatabase: SQLiteDatabase =
        SQLiteDatabase.openOrCreateDatabase(sqlLiteDatabasePath, null)


    //用来生成BaseDao对象
    fun <T> getBaseDao(entityClass: Class<T>): BaseDao<T>? {
        var baseDao: BaseDao<T>? = null
        try {
            baseDao = BaseDao::class.java.newInstance() as BaseDao<T>?
            baseDao?.init(sqlSQLiteDatabase, entityClass)
        } catch (e: InstantiationException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        }
        return baseDao
    }
}