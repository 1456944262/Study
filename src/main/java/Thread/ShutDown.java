package Thread;/**
 * Created by Administrator on 2018/11/1 0001.
 */

import java.util.concurrent.TimeUnit;

/**
 * @Description: 关闭线程的两种方式
 * @Author: yangjin
 * @CreateDate: 2018/11/1 0001$ 22:23$
 * @Version: 1.0
 */
public class ShutDown {
    public static void main(String[] args) throws InterruptedException {
        Runner one = new Runner();
        Thread countThread = new Thread(one, "CountThread");
        countThread.start();
        TimeUnit.SECONDS.sleep(1);
        countThread.interrupt();  //中断线程会释放资源
        Runner two = new Runner();
        countThread=new Thread(two,"CountThread");
        countThread.start();
        TimeUnit.SECONDS.sleep(1);
        two.cancle();
    }
    static class Runner implements Runnable{
        private volatile boolean on=true;
        private long i;
        public void run() {
        while (on&&!Thread.currentThread().isInterrupted()){
            i++;
           }
            System.out.println("Count i="+i);
        }
        public void cancle(){
            on=false;
        }
    }
}
