package Stack;/**
 * Created by Administrator on 2018/8/28 0028.
 */

/**
 * @Description: java类作用描述
 * @Author: yangjin
 * @CreateDate: 2018/8/28 0028$ 22:33$
 * @Version: 1.0
 */
public class Node<T> {


    public T date;
    public Node<T> next;

    public Node(){}

    public Node(T date){
        this.date=date;
    }
    public Node(T date,Node<T> next){
        this.date=date;
        this.next=next;
    }
}
