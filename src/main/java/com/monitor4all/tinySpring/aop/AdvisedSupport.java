package com.monitor4all.tinySpring.aop;

import org.aopalliance.intercept.MethodInterceptor;

/**
 * 织入辅助类
 */
public class AdvisedSupport {

    /**
     * 目标类
     */
    private TargetSource targetSource;

    /**
     * 要植入的切面逻辑类
     */
    private MethodInterceptor methodInterceptor;

    /**
     * 切面拦截匹配
     */
    private MethodMatcher methodMatcher;

    public TargetSource getTargetSource() {
        return targetSource;
    }

    public void setTargetSource(TargetSource targetSource) {
        this.targetSource = targetSource;
    }

    public MethodInterceptor getMethodInterceptor() {
        return methodInterceptor;
    }

    public void setMethodInterceptor(MethodInterceptor methodInterceptor) {
        this.methodInterceptor = methodInterceptor;
    }

    public MethodMatcher getMethodMatcher() {
        return methodMatcher;
    }

    public void setMethodMatcher(MethodMatcher methodMatcher) {
        this.methodMatcher = methodMatcher;
    }

}
