import com.monitor4all.tinySpring.dao.Car;
import com.monitor4all.tinySpring.dao.Wheel;
import com.monitor4all.tinySpring.ioc.xml.XmlBeanFactory;
import com.monitor4all.tinySpring.service.HelloService;
import org.junit.Test;

public class XmlBeanFactoryTest {

    @Test
    public void getBean() throws Exception {
        System.out.println("--------- IOC test ----------");
        String location = getClass().getClassLoader().getResource("tiny-spring.xml").getFile();
        XmlBeanFactory bf = new XmlBeanFactory(location);
        Wheel wheel = (Wheel) bf.getBean("wheel");
        System.out.println(wheel);
        Car car = (Car) bf.getBean("car");
        System.out.println(car);

//        System.out.println("\n--------- AOP test ----------");
//        HelloService helloService = (HelloService) bf.getBean("helloService");
//        helloService.sayHelloWorld();
    }
}
