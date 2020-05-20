package com.monitor4all.tinySpring.aop;

/**
 * 顾问切入点：切入点指切面具体织入的方法
 */
public interface PointcutAdvisor extends Advisor {

    Pointcut getPointcut();
}
