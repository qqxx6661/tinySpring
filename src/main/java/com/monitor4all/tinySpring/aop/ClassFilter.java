package com.monitor4all.tinySpring.aop;

/**
 * 类匹配接口
 */
public interface ClassFilter {

    Boolean matchers(Class beanClass) throws Exception;

}
