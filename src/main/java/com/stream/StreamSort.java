package com.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 类的描述
 * author: qiushi
 * date  : 2017/11/15
 */
public class StreamSort {
    public static void main(String[] args) {
        String consts = "cc";
        List<String> list3 = Arrays.asList("aa", "bb", "cc", "dd", "ee");
        List<String> collect = list3.stream().sorted((item1, item2) -> {
            if (!item1.equals(item2)) {
                if (consts.equals(item1)) return 1;
                if (consts.equals(item2)) return -1;
                return 0;
            } else {
                return 0;
            }
        }).collect(Collectors.toList());
        System.out.println(collect);

    }
}
