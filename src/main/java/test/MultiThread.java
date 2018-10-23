package test;/**
 * Created by Administrator on 2018/10/23 0023.
 */

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @Description: TMX 观察线程
 * @Author: yangjin
 * @CreateDate: 2018/10/23 0023$ 22:57$
 * @Version: 1.0
 */
public class MultiThread {

    public static void main(String[] args) {
        ThreadMXBean threadMXBean= ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        for (ThreadInfo threadInfo:threadInfos){
            System.out.println(threadInfo.getThreadId()+":"+threadInfo.getThreadName());
        }
    }
}
