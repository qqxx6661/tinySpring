package com.monitor4all.tinySpring.aop;

import java.lang.reflect.Method;

/**
 * 方法匹配接口
 */
public interface MethodMatcher {

    Boolean matchers(Method method, Class beanClass);

}
