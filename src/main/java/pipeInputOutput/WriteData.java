package pipeInputOutput;

import java.io.IOException;
import java.io.PipedOutputStream;

/**
 * Created by wangrongxuan on 2016/4/29.
 */
public class WriteData {
    public void writeMethod(PipedOutputStream out) {
        try {
            System.out.println("write:");
            for (int i = 0; i < 300; i++) {
                String outData = "" + (i + 1);
                out.write(outData.getBytes());
                System.out.println(outData);
                Thread.sleep(100);
            }
            System.out.println();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
