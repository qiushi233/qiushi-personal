package com.leetcode.array;
/**
 给定一个数组和一个目标数，从数组中找到两个数，使得这两个数之和等于这个目标数，返回两个数组的编号。
 Example
 给定一个数组 nums = [2, 7, 11, 15], target = 9,
 因为 nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].

 作者：草稿纸反面
 链接：https://www.jianshu.com/p/e2e0c0105afd
 来源：简书
 简书著作权归作者所有，任何形式的转载都请联系作者获得授权并注明出处。
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Description : TODO
 * Author : qiushi
 * Version : 1.0.0
 * CreateTime : 2019年05月09日 11:19:00
 */
public class Test2 {

    public static void main(String[] args) {
        int[] ints = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(ints, 9)));
    }
    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            //这里用了target - numbers[i]，如果map里有，就直接找到了两个答案
            if (map.containsKey(target - numbers[i])) {
                result[1] = i;
                //通过Map的get方法得到标号,这里得到的是两个数中遍前面的数，因此给result[0]
                result[0] = map.get(target - numbers[i]);
                //返回正确结果
                return result;
            }
            map.put(numbers[i], i);
        }
        return result;
    }
}
