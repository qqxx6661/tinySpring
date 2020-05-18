package com.monitor4all.tinySpring.aop;

import java.lang.reflect.Method;

public class AroundAdvice implements Advice {

    private Object bean;
    private MethodInvocation beforeMethodInvocation;
    private MethodInvocation afterMethodInvocation;

    public AroundAdvice(Object bean, MethodInvocation beforeMethodInvocation, MethodInvocation afterMethodInvocation) {
        this.bean = bean;
        this.beforeMethodInvocation = beforeMethodInvocation;
        this.afterMethodInvocation = afterMethodInvocation;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 在目标方法执行前调用通知
        System.out.println("在目标方法执行前调用打印日志方法：");
        beforeMethodInvocation.invoke();
        Object invoke = method.invoke(bean, args);
        //在真实的对象执行之后我们可以添加自己的操作
        System.out.println("在目标方法执行后调用打印日志方法：");
        afterMethodInvocation.invoke();
        return invoke;
    }
}
