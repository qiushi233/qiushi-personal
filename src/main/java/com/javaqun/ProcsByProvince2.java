package com.javaqun;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ProcsByProvince2 implements Callable<ProcsByProvince2> {

    public static int index = 0;

    public static void main(String[] args) {
        ProcsByProvince2 p = new ProcsByProvince2();
    }


    public ProcsByProvince2() {
        startThread(this);
    }

    public void startThread(ProcsByProvince2 p) {
        for (int i = 1; i <= 4; i++) {
            FutureTask<ProcsByProvince2> ft = new FutureTask<ProcsByProvince2>(this);
//			new Thread(this, provinceName + "Thread" + i).start();
//			exec.execute(ft);
            new Thread(ft).start();
        }
    }

    @Override
    public ProcsByProvince2 call() throws Exception {
        for (int i = 0; i < 10; i++) {
            synchronized (ProcsByProvince2.class) {
                index++;
            }
            System.out.println(Thread.currentThread().getName() + "------" + i);
        }
        return null;
    }
//
//	@Override
//	public void run() {
//		int index=0;
//		for(int i=0;;i++){
//			index++;
//			System.out.println(Thread.currentThread().getName()+"------"+i);
//		}
//	}

}
