package com.monitor4all.tinySpring.simple.aop;

public class LogTask implements MethodInvocation {
    @Override
    public void invoke() {
        System.out.println("打印一些日志...");
    }
}
