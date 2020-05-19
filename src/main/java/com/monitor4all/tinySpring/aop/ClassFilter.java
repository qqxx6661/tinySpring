package com.monitor4all.tinySpring.aop;

public interface ClassFilter {

    Boolean matchers(Class beanClass) throws Exception;

}
