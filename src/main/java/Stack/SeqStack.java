package Stack;

import java.io.Serializable;
import java.util.EmptyStackException;

/**
 * Created by Administrator on 2018/8/27 0027.
 * 顺序栈
 */
public class SeqStack<T> implements Stack<T>,Serializable {

    private int top=-1;

    private int capacity=10;

    private T[] array;

    private  int size;

    public SeqStack (int capacity){
           array=(T[])new Object[capacity];
    }

    public SeqStack (){
        array=(T[])new Object[this.capacity];
    }


    public int size(){
        return size;
    }


  /**
  * @Description:    java类作用描述
  * @CreateDate:     2018/8/27 23:56
  * @Version:        1.0
  */
    public boolean isEmpty() {
        return this.top==-1;
    }

    public void push(T data) {
          if(array.length==size){
              ensureCapacity(size*2+1);
          }
        array[++top]=data;
        size++;
    }

    public T peek() {
        if(isEmpty())new EmptyStackException();
          return array[top];
    }

    public T pop() {
        if(isEmpty())new EmptyStackException();
        size--;
        return array[top--];
    }

    public void ensureCapacity(int capacity){
        if(capacity<size)return;
        T[] old=array;
        array=(T[])new Object[capacity];
        for (int i=0;i<size;i++){
            array[i]=old[i];
        }

    }


    public static void main(String[] args) {
        SeqStack<String> stack = new SeqStack<String>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        System.out.println(stack.size());
        int size = stack.size;
        for (int i=0;i<size;i++){
            System.out.println(stack.pop());
        }
    }




}
