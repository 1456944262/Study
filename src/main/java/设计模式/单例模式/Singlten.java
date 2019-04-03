package 设计模式.单例模式;

/*
* 饿汉式
* */
public class Singlten {

    private static final  Singlten singlten=new Singlten();

    private Singlten() {
    }

    public Singlten getSinglten(){
        return singlten;
    }
}
/*
* 懒汉式,线程不安全
* */
class Singlten2{

    private static Singlten2 singlten2;

    private Singlten2(){}

    public static  Singlten2 getSinglten2(){
        if(singlten2 == null){
            singlten2 = new Singlten2();
        }
        return singlten2;
    }

}

/*
* 加synchronized的饿汉式
* */
class Singlten3{

    private static  Singlten3 singlten3;

    private Singlten3(){}

    public static synchronized Singlten3 getSinglten3(){
           if(singlten3 == null){
               singlten3 = new Singlten3();
           }
           return singlten3;
    }

}

/*
* 双重检查锁的懒汉式
* */
class Singlten4{
    private static Singlten4 singlten4;
    private Singlten4(){}

    public static Singlten4 getSinglten4(){
        if(singlten4 == null){
            synchronized (Singlten4.class){
                if(singlten4 == null){
                    singlten4 = new Singlten4();
                }
            }
        }
        return singlten4;
    }
}
/*
*还有另外2种：反射和静态内部类
* 枚举单例
* */
enum Singlten7{
    SINGLTEN_7;

//    public  Singlten7 getInstance(){
//        return SINGLTEN_7;
//    }
}