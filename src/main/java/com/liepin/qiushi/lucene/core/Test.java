package com.liepin.qiushi.lucene.core;

import org.apache.solr.common.SolrInputDocument;

import java.util.HashMap;

/**
 * Created by qiushi on 16/3/22.
 */
public class Test {
    public static void main(String[] args) {
//        Thread.currentThread().interrupt();
//        System.out.println(Thread.interrupted());
//        System.out.println(Thread.interrupted());
//
//        HashMap<String, String> map = new HashMap<>();
//        map.put("111","111");
//        map.put("222","222");
//        System.out.println(map);

        for (int i = -1000; i < 0; i++) {
            System.out.println(i+"\t"+Integer.toBinaryString(i));
        }
    }
}
