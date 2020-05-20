package com.monitor4all.tinySpring.ioc;

/**
 * 对Bean初始化前后做操作
 */
public interface BeanPostProcessor {

    Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception;

    Object postProcessAfterInitialization(Object bean, String beanName) throws Exception;
}
