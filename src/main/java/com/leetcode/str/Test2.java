package com.leetcode.str;/**
 * 类的描述
 * author: qiushi
 * date  : 2019/5/9
 */

/**
 * Description : TODO
 * Author : qiushi
 * Version : 1.0.0
 * CreateTime : 2019年05月09日 10:17:00
 *
 P   A   H   N
 A P L S I I G
 Y   I   R
 */
public class Test2 {
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }

    public static String convert(String s, int nRows) {
        //转化成char字符数组方便后面使用
        char[] c = s.toCharArray();
        //得到输入的字符数量
        int len = c.length;
        //用StringBuffer,后面详说
        StringBuffer[] sb = new StringBuffer[nRows];
        for (int i = 0; i < sb.length; i++) sb[i] = new StringBuffer();
        int i = 0;
        //关键代码，通过i++一个个读完
        while (i < len) {
            for (int idx = 0; idx < nRows && i < len; idx++) // vertically down
                sb[idx].append(c[i++]);
            for (int idx = nRows-2; idx >= 1 && i < len; idx--) // obliquely up
                sb[idx].append(c[i++]);
        }
        //把几行并到一起，然后输出
        for (int idx = 1; idx < sb.length; idx++)
            sb[0].append(sb[idx]);
        return sb[0].toString();
    }
}
