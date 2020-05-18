import com.monitor4all.tinySpring.ioc.SimpleIOC;
import com.monitor4all.tinySpring.dao.Car;
import com.monitor4all.tinySpring.dao.Wheel;
import org.junit.Test;

public class SimpleIOCTest {

    @Test
    public void getBean() throws Exception {

        // 拿到ioc.xml路径
        String location = SimpleIOC.class.getClassLoader().getResource("ioc.xml").getFile();
        // 通过ioc.xml初始化SimpleIOC
        SimpleIOC bf = new SimpleIOC(location);
        // 获取容器里两个类
        Wheel wheel = (Wheel) bf.getBean("wheel");
        System.out.println(wheel);
        Car car = (Car) bf.getBean("car");
        System.out.println(car);
    }
}

