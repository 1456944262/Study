/**
 * Copyright(C),2015‐2021,北京清能互联科技有限公司
 */
package 设计模式.装饰器模式;

/**
 * Description:  <br>
 *
 * @Author: yangjin@tsintergy.com
 * @Date: 2021/11/19 18:45
 * @Version: 1.0.0
 */
public class ConcreteDecoratorA extends Decorator{

    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    public void operationFirst(){
        System.out.println("OperationFirst say");
    }

    public void operationLast(){
        System.out.println("OperationLast say");
    }


    @Override
    public void operation(){
        operationFirst();
        super.operation();
        operationLast();
    }

    public void anotherOperation(){
        System.out.println("another operation");
    }

}