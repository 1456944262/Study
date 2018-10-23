package JUC;/**
 * Created by Administrator on 2018/10/9 0009.
 */

/**
 * @Description: java类作用描述
 * @Author: yangjin
 * @CreateDate: 2018/10/9 0009$ 22:26$
 * @Version: 1.0
 */
public class ReentrantLockDemo {
     /*final boolean nonfairTryAcquire(int acquires){
         final Thread current=Thread.currentThread();
         int c=getStates();
         //1.如果该锁未被任何线程占有，该锁被当前线程获取
       if(c==0){
           if(compareAndSetState(0,acquires)){
                setExclusiveOwnerThread(current);
                return  true;
           }
       }
       //2.若被占有，检查占有线程是否是当前线程
       else if(current==getExclusiveOwnerThread()){
           int nextc=c+acquires;
           if(nextc<0)throw new Error("Maximum lock count exceeded");
           setState(nextc);
           return  true;
       }
         return false;
     }*/



}
