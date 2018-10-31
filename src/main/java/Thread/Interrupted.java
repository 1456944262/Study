package Thread;/**
 * Created by Administrator on 2018/10/31 0031.
 */

import java.util.concurrent.TimeUnit;

/**
 * @Description: java类作用描述
 * @Author: yangjin
 * @CreateDate: 2018/10/31 0031$ 22:44$
 * @Version: 1.0
 */
public class Interrupted {
    public static void main(String[] args) throws InterruptedException {
        Thread sleepThread=new Thread(new SleepRunnable(),"SleepThread");
        sleepThread.setDaemon(true);
        Thread busyThread=new Thread(new BusyRunnable(),"BusyThread");
        busyThread.setDaemon(true);
        sleepThread.start();
        busyThread.start();
        TimeUnit.SECONDS.sleep(5);
        sleepThread.interrupt();
        busyThread.interrupt();
        System.out.println("SleepThread interrupt is"+sleepThread.isInterrupted());
        System.out.println("BusyThread interrupt is"+busyThread.isInterrupted());
        SleepUtils.seconds(2);
    }
    static class SleepRunnable implements Runnable{
        public void run() {
            while (true) {
                SleepUtils.seconds(10);
            }
        }
    }

    static class BusyRunnable implements  Runnable{
        public void run() {
            while (true){}
        }
    }
}
