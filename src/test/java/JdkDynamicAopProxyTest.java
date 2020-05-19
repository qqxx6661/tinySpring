import com.monitor4all.tinySpring.aop.AdvisedSupport;
import com.monitor4all.tinySpring.aop.JdkDynamicAopProxy;
import com.monitor4all.tinySpring.aop.LogInterceptor;
import com.monitor4all.tinySpring.aop.TargetSource;
import com.monitor4all.tinySpring.service.HelloService;
import com.monitor4all.tinySpring.service.HelloServiceImpl;
import org.junit.Test;

import java.lang.reflect.Method;

public class JdkDynamicAopProxyTest {

    @Test
    public void getProxy() throws Exception {
        System.out.println("---------- no proxy ----------");
        HelloService helloService = new HelloServiceImpl();
        helloService.sayHelloWorld();

        System.out.println("\n----------- proxy -----------");
        AdvisedSupport advisedSupport = new AdvisedSupport();
        advisedSupport.setMethodInterceptor(new LogInterceptor());

        TargetSource targetSource = new TargetSource(
                helloService, HelloServiceImpl.class, HelloServiceImpl.class.getInterfaces());
        advisedSupport.setTargetSource(targetSource);
        advisedSupport.setMethodMatcher((Method method, Class beanClass) -> true);

        helloService = (HelloService) new JdkDynamicAopProxy(advisedSupport).getProxy();
        helloService.sayHelloWorld();
    }

}
