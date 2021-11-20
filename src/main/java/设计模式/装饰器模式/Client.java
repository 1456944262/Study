/**
 * Copyright(C),2015‐2021,北京清能互联科技有限公司
 */
package 设计模式.装饰器模式;

/**
 * Description:  <br>
 *
 * @Author: yangjin@tsintergy.com
 * @Date: 2021/11/19 18:50
 * @Version: 1.0.0
 */
public class Client {

    public static void main(String[] args) {
        Component concreteComponent = new ConcreteComponent();
        Decorator decoratorA = new ConcreteDecoratorA(concreteComponent);
        decoratorA.operation();
        System.out.println("------------------------------------------");
        Decorator decoratorBandA = new ConcreteDecoratorA(decoratorA);
        decoratorBandA.operation();
    }
}