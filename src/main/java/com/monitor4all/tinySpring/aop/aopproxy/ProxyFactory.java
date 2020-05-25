package com.monitor4all.tinySpring.aop.aopproxy;

import com.monitor4all.tinySpring.aop.AdvisedSupport;
import com.monitor4all.tinySpring.aop.JdkDynamicAopProxy;

/**
 * 获取代理类工厂
 * 1. 实现获取代理类接口
 * 2. 继承织入辅助类
 */
public class ProxyFactory extends AdvisedSupport implements AopProxy {

    @Override
    public Object getProxy() {
        return createAopProxy().getProxy();
    }

    private AopProxy createAopProxy() {
        return new JdkDynamicAopProxy(this);
    }

}
