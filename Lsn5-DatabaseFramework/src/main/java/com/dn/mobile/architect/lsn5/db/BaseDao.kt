package com.dn.mobile.architect.lsn5.db

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import com.dn.mobile.architect.lsn5.anno.DbField
import com.dn.mobile.architect.lsn5.anno.DbTable
import java.lang.reflect.Field
import kotlin.collections.HashMap

/**
 * @author zhangshuai
 * @date 2022/6/15 星期三
 * @email zhangshuai@dushu365.com
 * @description
 * 1、完成自动建表的功能
 *
 */
class BaseDao<T> : IBaseDao<T> {

    //持有数据库操作的引用
    private var sqlLiteDataBase: SQLiteDatabase? = null

    //表名
    private var tableName: String? = null

    //使用操作数据库的所对应的java类型。通过字节码操作，灵活度最高
    private var entityClass: Class<T>? = null

    //是否初始化
    private var isInit: Boolean = false

    //定义一个缓存空间(key-字段名，value-成员变量)，每张表对应一个缓存map
    //例如: 数据库字段：_id, 类成员变量：id 。 _id -> id
    private var cacheMap: HashMap<String, Field>? = null

    //框架内部最好不用构造方法给调用层使用
    fun init(sqlLiteDataBase: SQLiteDatabase, entityClass: Class<T>): Boolean {
        this.sqlLiteDataBase = sqlLiteDataBase
        this.entityClass = entityClass

        //根据传入的entityClass类型来建立表，只需要建立一次
        if (!isInit) {
            //自动建表
            // 1、取到表名：如果没有添加注解，就是用类名，反之取注解中的值
            tableName = if (entityClass.getAnnotation(DbTable::class.java) == null) {
                //反射到类名
                entityClass.simpleName
            } else {
                //取注解上的名字
                entityClass.getAnnotation(DbTable::class.java).value
            }
            if (!sqlLiteDataBase.isOpen) {
                return false
            }
            //执行建表操作
            //create table if not exists tb_user(_id:integer,name:varchar2(20),password:varchar2(20))
            //单独使用方法生成create命令
            val createTable = getCreateTableSql()
            Log.i("print_logs", "BaseDao::init: $createTable")
            sqlLiteDataBase.execSQL(createTable)
            //缓存字段
            cacheMap = HashMap()
            initCacheMap()
            isInit = true
        }
        return isInit
    }

    /**
     * 创建建SQL表语句
     */
    private fun getCreateTableSql(): String {
        val sqlStr: StringBuffer = StringBuffer().apply {
            append("create table if not exists ")
            append("$tableName(")
            //反射得到所有的成员变量
            val fields = entityClass?.declaredFields
            fields?.forEach { field ->
                val type: Class<*> = field.type //拿到成员类型
                if (field.getAnnotation(DbField::class.java) != null) {
                    val fieldType: String = when (type) {
                        String::class.java -> {
                            "TEXT,"
                        }
                        Int::class.java -> {
                            "INTEGER,"
                        }
                        Long::class.java -> {
                            "LONG,"
                        }
                        Double::class.java -> {
                            "DOUBLE,"
                        }
                        Float::class.java -> {
                            "FLOAT,"
                        }
                        ByteArray::class.java -> {
                            "BLOB,"
                        }
                        else -> {
                            //不支持的类型
                            "TEXT"
                        }
                    }
                    append("${field.getAnnotation(DbField::class.java).value} $fieldType")
                } else {

                    val fieldType: String = when (type) {
                        String::class.java -> {
                            "TEXT,"
                        }
                        Int::class.java -> {
                            "INTEGER,"
                        }
                        Long::class.java -> {
                            "LONG,"
                        }
                        Double::class.java -> {
                            "DOUBLE,"
                        }
                        Float::class.java -> {
                            "FLOAT,"
                        }
                        ByteArray::class.java -> {
                            "BLOB,"
                        }
                        else -> {
                            //不支持的类型
                            "TEXT"
                        }
                    }
                    append("${field.name} $fieldType")
                }
            }

            //判断上面的字符最后一个逗号
            if (this[this.length - 1] == ',') {  //拿到字符
                this.deleteCharAt(this.length - 1)
            }
            append(")")
        }
        return sqlStr.toString()
    }

    private fun initCacheMap() {
        //1、渠道所有的列名
        val sqlStr = "select * from $tableName limit 1,0" //空表
        val cursor = sqlLiteDataBase?.rawQuery(sqlStr, null)
        val columnNames = cursor?.columnNames as Array<String> //获取表格所有列名

        //2、对所有的成员变量
        val fields = entityClass?.declaredFields as Array<Field>
        //打开所有字段的访问权限
        fields.forEach { it.isAccessible = true }

        //3、对1和2进行匹配映射
        for (columnName in columnNames) {
            var columnField: Field? = null
            for (field in fields) {
                val fieldName = if (field.getAnnotation(DbField::class.java) != null) {
                    field.getAnnotation(DbField::class.java).value
                } else {
                    field.name
                }
                if (columnName == fieldName) {
                    columnField = field
                    break
                }
            }

            if (columnField != null) {
                cacheMap?.put(columnName, columnField)
            }
        }

    }

    /**
     * 添加数据
     */
    override
    fun insert(entity: T): Long? {
        //准备好ContentValue中需要的数据
        val map = getValues(entity)

        //数据转移到ContentValues中
        val contentValues = mapToContentValues(map)

        return sqlLiteDataBase?.insert(tableName, null, contentValues)
    }

    /**
     * 字段和值的对应关系
     * 通过数据表字段对应的成员变量,从对象实例中获取到值
     * 然后返回[变量名,对应的值]。注意：获取到的变量名与数据库的字段名是一致的
     */
    private fun getValues(entity: T): HashMap<String, String> {
        val map = HashMap<String, String>()
        //返回类的所有的成员变量
        val filedIterator: MutableIterator<Field>? = cacheMap?.values?.iterator()

        filedIterator?.let {
            while (it.hasNext()) {
                val field = it.next()
                field.isAccessible = true
                //获取成员变量的值
                try {
                    val obj = field.get(entity) ?: continue  //获取entity类对象保存的值
                    val value = obj.toString()

                    //获取变量名。这里获取到的变量名与数据库的字段名是一致的
                    val key = if (field.getAnnotation(DbField::class.java) != null) {
                        field.getAnnotation(DbField::class.java).value
                    } else {
                        field.name
                    }
                    if (!key.isNullOrEmpty() && !value.isNullOrEmpty()) {
                        map[key] = value
                    }
                } catch (e: IllegalAccessException) {
                    e.printStackTrace()
                }
            }
        }
        return map
    }

    private fun mapToContentValues(map: Map<String, String>): ContentValues {
        val contentValues = ContentValues()
        val keys = map.keys
        val iterator = keys.iterator()
        while (iterator.hasNext()) {
            val key = iterator.next()
            val value = map[key]
            if (!value.isNullOrEmpty()) {
                contentValues.put(key, value)
            }
        }

        return contentValues
    }

    /**
     * 更新数据
     */
    override
    fun update(entity: T, where: T): Long {
        var result = -1L
        //准备好ContentValue中需要的数据
        val map = getValues(entity)
        //数据转移到ContentValues中
        val contentValues = mapToContentValues(map)

        val whereCause = getValues(where) //key=_id, value=1
        val condition = Condition(whereCause)


        return result
    }

    private class Condition {
        private var whereCause: String? = null
        private var whereArgs: Array<String>? = null

        constructor(whereCause: Map<String, String>) {
            val list = ArrayList<String>()
            val stringBuilder = StringBuilder()

            //取到当前的表的字段名
            val keySet: Set<String> = whereCause.keys
            val iterator = keySet.iterator()
            while (iterator.hasNext()) {
                val key = iterator.next()
                val value = whereCause[key]

                if (!value.isNullOrEmpty()) {
                    stringBuilder.append(" and ${key}=?")
                }
            }
        }

    }


    /**
     * 删除数据
     */
    override
    fun delete(where: T): Int {
        var result = -1

        return result
    }
}