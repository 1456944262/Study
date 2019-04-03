package SPI;

public class SpiAImpl implements Spi {
    public boolean isSupport(String name) {
        return "SPIA".equalsIgnoreCase(name.trim());
    }

    public String sayHello() {
        return "hello I am A";
    }
}
