package Thread;/**
 * Created by Administrator on 2018/10/29 0029.
 */

/**
 * @Description: 查看线程状态
 * @Author: yangjin
 * @CreateDate: 2018/10/29 0029$ 23:07$
 * @Version: 1.0
 */
public class ThreadState {

    public static void main(String[] args) {
            new Thread(new TimeWaiting(),"TimeWaitingThread").start();
            new Thread(new Waiting(),"WaitingThread").start();
            new Thread(new Blocked(),"BlockedThread-1").start();
            new Thread(new Blocked(),"BlockedThread--2").start();
    }

    static class TimeWaiting implements Runnable{
        public void run() {
            while (true){
                SleepUtils.seconds(100);
            }
        }
    }

    static class Waiting implements  Runnable{
        public void run() {
            while (true){
                synchronized (Waiting.class){
                    try {
                        Waiting.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    static  class Blocked implements  Runnable{
        public void run() {
            while (true){
                synchronized (Blocked.class){
                    SleepUtils.seconds(100);
                }
            }
        }
    }



}
