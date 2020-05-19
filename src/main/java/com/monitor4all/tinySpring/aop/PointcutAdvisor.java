package com.monitor4all.tinySpring.aop;

public interface PointcutAdvisor extends Advisor {

    Pointcut getPointcut();
}
