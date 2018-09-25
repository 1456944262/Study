package Stack;/**
 * Created by Administrator on 2018/8/28 0028.
 */

import java.io.Serializable;

/**
 * @Description: 栈的链式实现
 * @Author: yangjin
 * @CreateDate: 2018/8/28 0028$ 22:27$
 * @Version: 1.0
 */
public class LinkedStack<T> implements Stack<T>,Serializable {

    private Node<T> top;

    private int size;

    public LinkedStack(){
        this.top=new Node();
    }

    public int size(){
        return size;
    }



    public boolean isEmpty() {
      return top==null||top.date==null;
    }

    public void push(T data) {
           if(data==null)  throw  new StackException("data can\'t be null");
           if(top==null){
               this.top=new Node();
           }else if(this.top.date==null){
               this.top.date=data;
           }else{
               Node<T> p=new Node(data,this.top);
               top=p;
           }
         size++;
    }

    public T peek() {
       if(isEmpty()){
           throw  new StackException("Stack empty");
       }
       return top.date;
    }

    public T pop() {
        if(isEmpty()){
            throw new StackException("Stack empty");
        }
        T data=top.date;
        top = top.next;
        size--;
        return data;
    }


    public static void main(String[] args) {
        LinkedStack<String> sl = new LinkedStack<String>();
        sl.push("a");
        sl.push("b");
        sl.push("c");
        int length=sl.size();
        for(int i=0;i<length;i++){
            System.out.println(sl.pop());
        }
    }
}
