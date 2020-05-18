package com.monitor4all.tinySpring.ioc.factory;

public interface BeanFactoryAware {
    void setBeanFactory(BeanFactory beanFactory) throws Exception;
}
