package com.monitor4all.tinySpring.aop;

import java.lang.reflect.Method;

public interface MethodMatcher {

    Boolean matchers(Method method, Class beanClass);

}
