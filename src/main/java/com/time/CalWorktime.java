package com.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 计算时间
 * author: qiushi
 * date  : 2018/12/29
 */
public class CalWorktime {
    private static String[] times = {
            "10:14-20:13",
            "10:13-22:44",
            "10:13-22:25",
            "10:13-20:06",
            "10:13-20:47",
            "09:57-20:26",
            "09:52-19:03",
            "09:28-22:03",
            "09:46-20:35",
            "09:38-20:41",
            "09:47-20:03",
            "09:45-20:20",
            "09:51-21:35",
            "09:43-21:55",
            "09:41-21:24",
            "09:51-20:42",
            "09:21-21:43",
            "09:40-22:29",
            "09:24-21:46",
            "09:48-21:37",
            "09:42-19:00"
    };

    private static String dateStr = "2018-12-29 ";

    public static void main(String[] args) throws Exception {
        long allTime = 0l;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        for (String time : times) {
            String[] split = time.split("-");
            long beginTime = dateFormat.parse(dateStr + split[0]).getTime();
            long endTime = dateFormat.parse(dateStr + split[1]).getTime();
            long costtime = endTime - beginTime;
            allTime = allTime + costtime;
        }
        //转化为小时数
        double hours = allTime * 1.0d / times.length / 1000 / 60 / 60;
        System.out.println(hours);
    }
}
