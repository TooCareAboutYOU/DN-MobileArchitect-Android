package com.dn.mobile.architect.lsn4.aop.aspect

import android.util.Log
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.*
import kotlin.jvm.Throws

/**
 * @author zhangshuai
 * @date 2022/6/9 星期四
 * @email zhangshuai@dushu365.com
 * @description
 * 参考项目：https://github.com/TooCareAboutYOU/Aop-android/blob/master/README.md
 *
 * 注：被Aspect注解的类名必须以"AspectJ"结尾
 */

@Aspect
class BehaviorTraceAspectJ {

    //定义切面的规则
    //切入点
    //1、就在原来应用中哪些注释的地方放到的当前切面进行处理
    //execution(注释名，注释用的地方)
    //
    @Pointcut(
        "execution(@com.dn.mobile.architect.lsn4.aop.aspect.BehaviorTrace  * *(..))",
        argNames = "executionMethodDuration"
    )
    fun executionMethodDuration() {
        Log.i("print_logs", "BehaviorTraceAspect::executionMethodDuration:切入点")
    }

    /**
     * 前置通知，在目标执行之前通知
     */
    @Before(value = "executionMethodDuration()", argNames = "durationBefore")
    fun durationBefore() {
        Log.i("print_logs", "BehaviorTraceAspect::durationBefore:切入点执行前")
    }

    @Around(value = "executionMethodDuration()") //, argNames = "durationAroundJoin"
    @Throws(Throwable::class)
    fun durationAroundJoin(joinPoint: ProceedingJoinPoint): Any? {
        val beforeTime = System.currentTimeMillis()
        Log.i("print_logs", "BehaviorTraceAspect::durationAround: 切入点执行前时间${beforeTime}")
        joinPoint.proceed()
        val afterTime = System.currentTimeMillis() - beforeTime
        Log.i("print_logs", "BehaviorTraceAspect::durationAround: 切入点执行后时间${afterTime}")
        return null
    }

    /**
     * jinPoint.proceed()
     * 后置返回通知，目标执行之后通知
     */
    @After(value = "executionMethodDuration()", argNames = "durationAfter")
    fun durationAfter() {
        Log.i("print_logs", "BehaviorTraceAspect::durationAfter:切入点执行后")
    }

    /**
     * 后置返回通知，目标返回时执行通知
     */
    @AfterReturning(value = "executionMethodDuration()", argNames = "durationAfterReturning")
    fun durationAfterReturning() {
        Log.i("print_logs", "BehaviorTraceAspect::durationAfterReturning:切入点执行返回时")
    }

    /**
     * 异常通知，目标抛出异常时执行通知
     */
    @AfterThrowing(value = "executionMethodDuration()", argNames = "durationAfterThrowing")
    fun durationAfterThrowing(throwable: Throwable) {
        Log.i("print_logs", "BehaviorTraceAspect::durationAfterThrowing: 切入点执行异常= $throwable")
    }
}