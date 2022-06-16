package com.dn.mobile.architect.lsn5.db;

import android.database.sqlite.SQLiteDatabase;

import com.dn.mobile.architect.lsn5.anno.DbTable;

/**
 * @author zhangshuai
 * @date 2022/6/15 星期三
 * @email zhangshuai@dushu365.com
 * @description
 */
class BaseDaoFactory2 {

    private String sqlLiteDatabasePath = "data/data/com.dn.mobile.architect.lsn5/test.db";

    private SQLiteDatabase sqlSQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(
            sqlLiteDatabasePath,
            null);

    public <T> BaseDao<T> getBaseDao(Class<T> entityClass) {
        BaseDao baseDao = null;
        try {
            baseDao = BaseDao.class.newInstance();
            baseDao.init(sqlSQLiteDatabase, entityClass);
        } catch (IllegalAccessException mE) {
            mE.printStackTrace();
        } catch (InstantiationException mE) {
            mE.printStackTrace();
        }
        return baseDao;
    }

    public <T> String init(Class<T> entityClass) {
        String name;
        if (entityClass.getAnnotation(DbTable.class) == null) {
            name = entityClass.getName();
        } else {
            name = entityClass.getAnnotation(DbTable.class)
                    .value();
        }
        return name;
    }

}
