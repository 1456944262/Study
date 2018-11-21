package Thread;/**
 * Created by Administrator on 2018/11/1 0001.
 */

/**
 * @Description: 查看class文件
 * @Author: yangjin
 * @CreateDate: 2018/11/1 0001$ 22:50$
 * @Version: 1.0
 */
public class Synchronized {
    public static void main(String[] args) {
        synchronized (Synchronized.class){
            m();
        }
    }
    public static synchronized void m(){};
}
