/**
 * Copyright(C),2015‐2021,北京清能互联科技有限公司
 */
package 设计模式.装饰器模式;

/**
 * Description:  <br>
 *
 * @Author: yangjin@tsintergy.com
 * @Date: 2021/11/19 18:43
 * @Version: 1.0.0
 */
public abstract class Decorator extends Component{

    Component component;


    public Decorator(Component component){
        this.component = component;
    }

    @Override
    public void operation(){
        component.operation();
    }


}