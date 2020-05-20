package com.monitor4all.tinySpring.aop;

/**
 * 切入点
 */
public interface Pointcut {

    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();

}
