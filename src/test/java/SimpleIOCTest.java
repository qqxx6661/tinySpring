import com.monitor4all.tinySpring.SimpleIOC;
import com.monitor4all.tinySpring.dao.Car;
import com.monitor4all.tinySpring.dao.Wheel;
import org.junit.Test;

public class SimpleIOCTest {

    @Test
    public void getBean() throws Exception {
        String location = SimpleIOC.class.getClassLoader().getResource("ioc.xml").getFile();
        SimpleIOC bf = new SimpleIOC(location);
        Wheel wheel = (Wheel) bf.getBean("wheel");
        System.out.println(wheel);
        Car car = (Car) bf.getBean("car");
        System.out.println(car);
    }
}

