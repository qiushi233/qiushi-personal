package com.spring;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by qiushi on 16/5/9.
 */
public class BeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("execute before (by " + method.getDeclaringClass().getName() + "." + method.getName() + ")");
    }
}
