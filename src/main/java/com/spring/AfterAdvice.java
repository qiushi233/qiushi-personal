package com.spring;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * Created by qiushi on 16/5/9.
 */
public class AfterAdvice implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println(method.getDeclaringClass().getName() + "." + method.getName() + "spend time: " + returnValue);
        System.out.println("execute after (by " + method.getDeclaringClass().getName() + "." + method.getName() + ")");
    }
}
