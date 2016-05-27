package com.javaqun.perf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static ArrayList<StudentInfo> list = new ArrayList<StudentInfo>();

    public static void main(String[] args) {

        while (true) {
            System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
            System.out.println(" 1.建立成绩表    2.显示成绩表    3.查找     4.排序     5.添加     6.修改    7.删除     0.退出 ");
            System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
            System.out.println("请输入你的选择：");
            Scanner sc = new Scanner(System.in);
            int select = sc.nextInt();
            switch (select) {
                case 1:
                    establish();
                    break;
                case 2:
                    show();
                    break;
                case 3:
                    search();
                    break;
                case 4:
                    sort();
                    break;
                case 5:
                    add();
                    break;
                case 6:
                    update();
                    break;
                case 7:
                    remove();
                    break;
                case 0:
                    System.out.println("退出");
                    System.exit(1);
            }
        }
    }

    static Scanner sc = new Scanner(System.in);

    private static void remove() {
        System.out.println("输入要删除的学号:");
        int searchNo = sc.nextInt();
        for (int i = 0; i < list.size(); i++) {
            StudentInfo s = list.get(i);
            if (s.getNo() == searchNo) {
                list.remove(i);
                break;
            }
        }
    }

    private static void update() {
    }

    private static void establish() {//建立

        while (true) {
            add();
            System.out.println("1.继续添加  0.返回主菜单");
            int select = sc.nextInt();
            if (select == 0) {
                break;
            }
        }

    }

    private static void search() {//查找

        System.out.println("输入要查询的学号");
        int searchNo = sc.nextInt();
        for (int i = 0; i < list.size(); i++) {
            StudentInfo s = list.get(i);
            if (s.getNo() == searchNo) {
                System.out.println("====================================");
                System.out.println("学号\t\t姓名\t\t分数");
                System.out.println(s.toString());
                break;
            }
        }
    }

    private static void show() {//显示
        System.out.println("====================================");
        System.out.println("学号\t\t姓名\t\t分数");
        for (int i = 0; i < list.size(); i++) {
            StudentInfo s = list.get(i);
            System.out.println(s.toString());
        }
    }

    private static void add() {//添加
        StudentInfo s = new StudentInfo();

        System.out.print("请输入学号:");
        int no = sc.nextInt();

        System.out.print("请输入姓名：");
        String name = sc.next();

        System.out.print("请输入分数：");
        int score = sc.nextInt();

        s.setNo(no);
        s.setName(name);
        s.setScore(score);

        list.add(s);

        System.out.println("添加成功 " + s.toString());
    }

    private static void sort() {//排序

        Collections.sort(list, new Comparator<StudentInfo>() {
            @Override
            public int compare(StudentInfo o1, StudentInfo o2) {
                if (o1.getScore() < o2.getScore()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

    }
}


