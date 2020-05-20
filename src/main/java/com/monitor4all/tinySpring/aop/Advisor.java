package com.monitor4all.tinySpring.aop;

import org.aopalliance.aop.Advice;

/**
 * 顾问：顾问是切面的另一种实现，能够将通知以更为复杂的方式织入到目标对象中，是将通知包装为更复杂切面的装配器
 */
public interface Advisor {

    Advice getAdvice();
}
