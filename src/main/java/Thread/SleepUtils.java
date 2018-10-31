package Thread;/**
 * Created by Administrator on 2018/10/29 0029.
 */

import java.util.concurrent.TimeUnit;

/**
 * @Description: java类作用描述
 * @Author: yangjin
 * @CreateDate: 2018/10/29 0029$ 23:18$
 * @Version: 1.0
 */
public  class SleepUtils {
    public static  final  void seconds(long seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
