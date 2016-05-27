package com.javaqun;

import java.util.concurrent.FutureTask;

public class ProcsByProvince3 implements Runnable {

    public static FutureTask<ProcsByProvince3> ft;


    public static void main(String[] args) {
        ProcsByProvince3 p=new ProcsByProvince3();
    }


    public ProcsByProvince3() {
        startThread(this);
    }

    public void startThread(ProcsByProvince3 p) {
//		ft = new FutureTask<>(this);
        for (int i = 1; i <= 4; i++) {
            new Thread(this).start();
//				new Thread(ft).start();
        }
    }

//	@Override
//	public ProcsByProvince3 call()throws Exception {
//		int index=0;
//		for(int i=0;;i++){
//			index++;
//			System.out.println(Thread.currentThread().getName()+"------"+i);
//		}
//	}

    @Override
    public void run() {
        int index=0;
        for(int i=0;;i++){
            index++;
            System.out.println(Thread.currentThread().getName()+"------"+i);
        }
    }

}
