package com.spring;

import java.lang.reflect.Method;

/**
 * Created by qiushi on 16/5/9.
 */
public class TracingThrowsAdvice implements org.springframework.aop.ThrowsAdvice {

    public void afterThrowing(Method method, Object[] args, Object target, Throwable subclass) {
        System.out.println("Logging that a " + subclass + "Exception was thrown.");
    }
}
