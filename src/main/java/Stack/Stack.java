package Stack;

/**
 * Created by Administrator on 2018/8/27 0027.
 */
public interface Stack<T> {

     //判断是否空
      boolean isEmpty();

    //入栈
      void push(T data);

    //出栈返回栈顶元素
      T peek();

    //出栈
    T pop();


}
