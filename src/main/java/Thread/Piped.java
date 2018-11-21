package Thread;/**
 * Created by Administrator on 2018/11/21 0021.
 */

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * @Description:管道流 用于线程之间的通信
 * @Author: yangjin
 * @CreateDate: 2018/11/21 0021$ 21:51$
 * @Version: 1.0
 */
public class Piped {
    public static void main(String[] args) throws IOException {
        PipedReader reader = new PipedReader();
        PipedWriter writer = new PipedWriter();
        //输出流和和输入流进行连接否则会抛异常
        writer.connect(reader);
        Thread thread = new Thread(new Print(reader),"PrintThread");
         thread.start();
         int receive=0;
         try {
             while ((receive = System.in.read()) != -1) {
                 writer.write(receive);
             }
         }catch (Exception e){
             e.printStackTrace();
         }finally {
             writer.close();
         }
    }
    static class Print implements Runnable{
         private  PipedReader in;

        public Print(PipedReader reader){
            this.in=reader;
        }

        public void run() {
           int receive=0;
            try {
                while ((receive=in.read())!=-1){
                    System.out.print((char)receive);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
