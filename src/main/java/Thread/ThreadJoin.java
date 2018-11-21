package Thread;/**
 * Created by Administrator on 2018/11/21 0021.
 */

import java.util.concurrent.TimeUnit;

/**
 * @Description: Thread.join()方法
 * 也就是线程0结束了，线程1才能从join()方法中返回，而线程0需要等待main线程结
 *束
 * @Author: yangjin
 * @CreateDate: 2018/11/21 0021$ 22:30$
 * @Version: 1.0
 */
public class ThreadJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread previous = Thread.currentThread();
        for(int i=0;i<10;i++){
            Thread thread = new Thread(new Domino(previous), String.valueOf(i));
            thread.start();
            previous=thread;
        }
        TimeUnit.SECONDS.sleep(5);
        System.out.println(Thread.currentThread().getName()+"terminate.");
    }
    static class Domino implements Runnable{
        private Thread thread;
        public Domino(Thread thread){
            this.thread=thread;
        }
        public void run() {
             try{
                 thread.join();
             }catch (Exception e){
                 e.printStackTrace();
             }
            System.out.println(Thread.currentThread().getName()+"terminate.");
        }
    }


}
