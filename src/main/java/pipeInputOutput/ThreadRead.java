package pipeInputOutput;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * Created by wangrongxuan on 2016/4/29.
 */
public class ThreadRead extends Thread {
    private ReadData read;
    private PipedInputStream input;

    public ThreadRead(ReadData read, PipedInputStream input) {
        this.read = read;
        this.input = input;
    }

    @Override
    public void run() {
        read.readMethod(input);
    }
}
