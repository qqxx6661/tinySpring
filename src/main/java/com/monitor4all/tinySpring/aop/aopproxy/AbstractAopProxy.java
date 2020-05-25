package com.monitor4all.tinySpring.aop.aopproxy;

import com.monitor4all.tinySpring.aop.AdvisedSupport;

/**
 * AOP代理抽象类
 * 实现：获取代理类接口
 */
public abstract class AbstractAopProxy implements AopProxy {

    protected AdvisedSupport advised;

    public AbstractAopProxy(AdvisedSupport advised) {
        this.advised = advised;
    }
    
}
