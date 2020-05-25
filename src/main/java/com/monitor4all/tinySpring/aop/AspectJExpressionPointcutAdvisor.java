package com.monitor4all.tinySpring.aop;

import com.monitor4all.tinySpring.aop.advisor.PointcutAdvisor;
import org.aopalliance.aop.Advice;

/**
 * AspectJ实现表达式顾问切入类
 * 定义：表达式切入点AspectJExpressionPointcut
 * 定义：一个需要织入的逻辑Advice
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {

    private AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();

    private Advice advice;

    public void setExpression(String expression) {
        pointcut.setExpression(expression);
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    @Override
    public Pointcut getPointcut() {
        return pointcut;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }

}
