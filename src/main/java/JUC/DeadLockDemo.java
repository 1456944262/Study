package JUC;/**
 * Created by Administrator on 2018/9/6 0006.
 */

/**
 * @Description: java类作用描述
 * @Author: yangjin
 * @CreateDate: 2018/9/6 0006$ 21:08$
 * @Version: 1.0
 */
public class DeadLockDemo {
    private static String resourcea="a";
    private static String resourceb="b";

    public static void main(String[] args) {
        deadLock();
    }
    public static  void deadLock(){
        Thread threada=new Thread(new Runnable() {
            @Override
            public void run() {
                    synchronized (resourcea){
                        System.out.println("threada get resource a");
                        try{
                            Thread.sleep(3000);
                            synchronized (resourceb){
                                System.out.println("threada get resource b");
                            }
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
            }
        });

        Thread threadb=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceb){
                    System.out.println("threadb get resource b");
                    synchronized (resourcea){
                        System.out.println("threadb get resource a");
                    }
                }
            }
        });
        threada.start();
        threadb.start();

    }
}
