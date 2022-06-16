package com.dn.mobile.architect.lsn4.aop.aspect

/**
 * @author zhangshuai
 * @date 2022/6/9 星期四
 * @email zhangshuai@dushu365.com
 * @description 用来标识性能检测
 */
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class BehaviorTrace(val value: String)
