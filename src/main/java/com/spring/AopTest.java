package com.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by qiushi on 16/5/9.
 */
public class AopTest {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        IBusinessLogic ibl = (IBusinessLogic) ac.getBean("businessLogicBean");
        ibl.foo();
        try {
            ibl.bar();
        } catch (BusinessLogicException e) {
            System.out.println("Caught BusinessLogicException");
        }
        ibl.time();
    }
}
