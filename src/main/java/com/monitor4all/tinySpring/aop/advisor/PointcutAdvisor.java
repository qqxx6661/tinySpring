package com.monitor4all.tinySpring.aop.advisor;

import com.monitor4all.tinySpring.aop.Pointcut;
import com.monitor4all.tinySpring.aop.advisor.Advisor;

/**
 * 顾问切入点：切入点指切面具体织入的方法
 */
public interface PointcutAdvisor extends Advisor {

    Pointcut getPointcut();
}
