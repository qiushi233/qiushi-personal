package com.liepin.qiushi.lucene.core;

/**
 * Created by qiushi on 16/3/30.
 */
public class Person {

    public static void main(String[] args) {
        Class<? super Person> superclass = Person.class.getSuperclass();
        System.out.println(superclass == Object.class);
    }
}
