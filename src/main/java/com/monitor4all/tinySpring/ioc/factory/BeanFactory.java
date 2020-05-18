package com.monitor4all.tinySpring.ioc.factory;

public interface BeanFactory {

    Object getBean(String beanId) throws Exception;
}
