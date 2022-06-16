package com.dn.mobile.architect.lsn5.anno


/**
 * @author zhangshuai
 * @date 2022/6/15 星期三
 * @email zhangshuai@dushu365.com
 * @description
 */
@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class DbTable(val value: String = "")
