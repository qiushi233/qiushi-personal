package com.meituan.spring;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * spring注解demo
 * author: qiushi
 * date  : 2017/10/27
 */
public class AnnotationDemo1 {
    public static void main(String[] args) {
        Long now = new Date().getTime();
        System.out.println(now);

        String res;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String format = sdf.format(now);
        System.out.println(format);

        System.out.println(ProcessHandle.current().toString());
    }
}
