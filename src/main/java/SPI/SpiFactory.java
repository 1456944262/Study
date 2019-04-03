package SPI;

import java.util.ServiceLoader;

public class SpiFactory {
    private static ServiceLoader serviceLoader=ServiceLoader.load(Spi.class);
    public static Spi getSpi(String name){
//        for (Spi spi:serviceLoader) {
//            if(spi.isSupport(name)){
//                return spi;
//            }
//        }
        return  null;
    }
}
