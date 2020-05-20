package com.monitor4all.tinySpring.aop;

/**
 * 目标类
 */
public class TargetSource {

    /**
     * 目标类实现类
     */
    private Class<?> targetClass;

    /**
     * 目标类实现的接口
     */
    private Class<?>[] interfaces;

    /**
     * 目标类
     */
    private Object target;

    public TargetSource(Object target, Class<?> targetClass, Class<?>... interfaces) {
        this.target = target;
        this.targetClass = targetClass;
        this.interfaces = interfaces;
    }

    public Class<?> getTargetClass() {
        return targetClass;
    }

    public Object getTarget() {
        return target;
    }

    public Class<?>[] getInterfaces() {
        return interfaces;
    }
}
