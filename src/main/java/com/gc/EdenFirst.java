package com.gc;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Described：Edon优先划分对象测试
 * @VM params : -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -verbose:gc
 * Edon s0 s1 old
 * 8  1   1  10
 */
public class EdenFirst {

    private final static int ONE_MB = 1024 * 1024;

    public static void main(String[] args) {
        @SuppressWarnings("unused")
        byte[] testCase1, testCase2, testCase3, testCase4;
        testCase1 = new byte[2 * ONE_MB];
        testCase2 = new byte[2 * ONE_MB];
        testCase3 = new byte[2 * ONE_MB];
//     testCase1 = null;
//     testCase2 = null;
//     testCase3 = null;
        testCase4 = new byte[2 * ONE_MB];
    }

}
