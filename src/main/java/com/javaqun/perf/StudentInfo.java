package com.javaqun.perf;

public class StudentInfo {

    private int no;
    private String name;
    private int score;

    public void setNo(int no) {
        this.no = no;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getNo() {

        return no;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return  no + "\t\t" + name + "\t\t" + score;
    }
}
