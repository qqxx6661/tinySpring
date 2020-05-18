package com.monitor4all.tinySpring.aop;

public class LogTask implements MethodInvocation {
    @Override
    public void invoke() {
        System.out.println("执行打印日志逻辑");
    }
}
