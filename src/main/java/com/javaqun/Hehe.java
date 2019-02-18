package com.javaqun;

import com.google.common.collect.Lists;

import java.util.ArrayList;

/**
 * Created by qiushi on 16/7/1.
 */
public class Hehe {
    public static void main(String[] args) {
        System.out.println(1);
        ArrayList<Object> list = Lists.newArrayList();
        list.add("111");
        list.add("222");

        int count =0;
        System.out.println(list.get(count++));
        System.out.println(list.get(count++));

    }
}
