package com.leetcode.str;/**
 * 类的描述
 * author: qiushi
 * date  : 2019/4/26
 */

import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Map;

/**
 *给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。

 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

 你可以假设 nums1 和 nums2 不会同时为空。

 示例 1:

 nums1 = [1, 3]
 nums2 = [2]

 则中位数是 2.0
 示例 2:

 nums1 = [1, 2]
 nums2 = [3, 4]

 则中位数是 (2 + 3)/2 = 2.5
 */
public class Test1 {
    public static void main(String[] args) {
        String str = "abcdaef";

        char[] chars = str.toCharArray();
        Map<Character, Integer> charMap = new HashMap<>();
        int length = 0;
        for (int i =0,j=0;j<chars.length;j++){
            if (charMap.containsKey(chars[j])){
                i = Math.max(charMap.get(chars[j]) + 1, i);
            }
            charMap.put(chars[j],j);
            length = Math.max(length, j - i + 1);
        }
        System.out.println(length);
    }
}
