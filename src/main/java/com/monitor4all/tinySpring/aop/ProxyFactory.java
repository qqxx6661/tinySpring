package com.monitor4all.tinySpring.aop;

public class ProxyFactory extends AdvisedSupport implements AopProxy {

    @Override
    public Object getProxy() {
        return createAopProxy().getProxy();
    }

    private AopProxy createAopProxy() {
        return new JdkDynamicAopProxy(this);
    }

}
