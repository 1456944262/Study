package Colletions;

import java.util.LinkedList;

/**
 * Created by Administrator on 2018/8/22 0022.
 */
public class ListDemo {
    static  LinkedList<String> list = new LinkedList<String>();

    static  class thread1 implements Runnable{
        public void run() {
                   for (int i=1;i<1000;i++){
                       list.add(String.valueOf(i));
                   }
           }
    }


    static class thread2 implements Runnable{
        public void run() {
            for (int i=1;i<1000;i++){
                list.add(String.valueOf(i+1000));
            }
        }
    }

    public static void main(String[] args) {
         new Thread(new thread1()).start();
         new Thread(new thread2()).start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }
}
