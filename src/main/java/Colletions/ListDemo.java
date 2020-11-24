package Colletions;

import java.util.LinkedList;


public class ListDemo {

    //linkList 插入速度快
    static  LinkedList<String> list = new LinkedList<String>();

    static  class thread1 implements Runnable{
        @Override
        public void run() {
                   for (int i=1;i<1000;i++){
                       list.add(String.valueOf(i));
                   }
           }
    }


    static class thread2 implements Runnable{
        @Override
        public void run() {
            for (int i=1;i<1000;i++){
                list.add(String.valueOf(i+1000));
            }
            System.out.println("c");
        }
    }



    static class thread3 extends Thread{
        @Override
        public void run() {
            for (int i=1;i<1000;i++){
                list.add(String.valueOf(i+2000));
            }
            System.out.println("b");
        }
    }

    static class thread4 extends Thread{
        @Override
        public void run() {
            for (int i=1;i<1000;i++){
                list.add(String.valueOf(i+3000));
            }
            System.out.println("a");
        }
    }

    public static void main(String[] args) throws Exception{
        Thread thread = new Thread(new thread4());
        Thread thread1 = new Thread(new thread3());
        Thread thread2 = new Thread(new thread2());
        thread1.start();
        thread.start();
        thread2.start();
        thread2.join();
        thread.join();
        System.out.println("主线程执行完毕");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }
}
