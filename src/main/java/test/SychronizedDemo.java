package test;/**
 * Created by Administrator on 2018/10/15 0015.
 */

/**
 * @Description: 测试sychronized锁代码块和锁方法的区别
 * synchronized修饰不加static的方法，锁是加在单个对象上，不同的对象没有竞争关系；修饰加了static的方法，锁是加载类上，这个类所有的对象竞争一把锁。
 * @Author: yangjin
 * @CreateDate: 2018/10/15 0015$ 23:34$
 * @Version: 1.0
 */
public class SychronizedDemo {
    private int num;
    public synchronized  void method0(String args){
            try{
                if ("a".equals(args)) {
                    num=100;
                    System.out.println("tag a set number over");
                    Thread.sleep(1000);
                }else{
                    num=200;
                    System.out.println("tag b set number over");
                }
                System.out.println("tag="+args+";num="+num);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    public static void main(String[] args) {
        final SychronizedDemo s1 = new SychronizedDemo();
        final SychronizedDemo s2 = new SychronizedDemo();
        Thread thread1=new Thread(new Runnable() {
            public void run() {
                s1.method0("a");
            }
        });
        thread1.start();
        Thread thread2=new Thread(new Runnable() {
            public void run() {
                s2.method0("b");
            }
        });
        thread2.start();


    }

}
