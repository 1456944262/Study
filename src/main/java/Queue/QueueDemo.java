package Queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2018/8/20 0020.
 */
public class QueueDemo {

    //定义篮子用来放苹果
    public static class  Basket{

      BlockingQueue basket=new ArrayBlockingQueue<String>(3);

      //生产者生产苹果 put方法会阻塞
       public void produce() throws InterruptedException {
               basket.put("an apple");//添加一个元素，如果队列满则阻塞
              //basket.add("an apple"); //增加一个元素 如果对列已满则抛出异常  InterruptedException
              //boolean offer = basket.offer("an apple");//添加一个元素，如果队列已满，则返回false,不阻塞
              //String poll =(String)basket.poll();//移除并返回元素头，队列为空的时候返回null
              //String remove = (String)basket.remove();//移除并返回元素头，队列为空时抛异常NoSuchElementException
              //String element =(String) basket.element();//返回队列头部元素，如果为空则抛异常NoSuchElementException
              //String peek = (String) basket.peek();//返回队列头部元素，如果队列为空则返回null
              //String take = (String) basket.take();//返回队列头部元素，如果队列为空则阻塞
       }

       //取出苹果,take方法会阻塞
       public String consume() throws InterruptedException {
           String take = (String) basket.take();
           return take;
       }


       public int getAppleNumber(){
           return  basket.size();
       }
    }

      //测试
      public static void test(){
        //创建一个篮子
        final Basket basket=new Basket();

         //定义生产者
          class Producer implements  Runnable{
              public void run() {
                  try {
                  while (true){
                          System.out.println("开始生产苹果:"+System.currentTimeMillis());
                          basket.produce();
                          System.out.println("生产苹果结束:"+System.currentTimeMillis());
                          Thread.sleep(300);
                          System.out.println("生产后有"+basket.getAppleNumber()+"个苹果");
                      }
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }

              }
          }

          class Consumer implements  Runnable{

              public void run() {
                  try {
                  while (true){
                          System.out.println("消费者开始消费苹果");
                          basket.consume();
                          System.out.println("消费者消费苹果结束");
                          System.out.println("消费后有"+basket.getAppleNumber()+"个苹果");
                          Thread.sleep(1000);
                       }
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
              }
          }

          ExecutorService executorService = Executors.newCachedThreadPool();
          Producer producer = new Producer();
          Consumer consumer = new Consumer();
          executorService.submit(producer);
          executorService.submit(consumer);

          try {
              Thread.sleep(10000);
          } catch (InterruptedException e) {
          }

          executorService.shutdownNow();
      }











    public static void main(String[] args) throws InterruptedException {
          QueueDemo.test();
    }
}
