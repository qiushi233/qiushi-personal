package com.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by qiushi on 16/5/10.
 */
public class LockTest {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
    }
}
