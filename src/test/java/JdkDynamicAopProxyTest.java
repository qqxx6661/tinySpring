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
        TargetSource targetSource = new TargetSource(helloService, HelloServiceImpl.class, HelloServiceImpl.class.getInterfaces());
        AdvisedSupport advisedSupport = new AdvisedSupport();
        advisedSupport.setMethodInterceptor(new LogInterceptor());
        advisedSupport.setTargetSource(targetSource);
        // 默认返回true：即默认需要织入切面逻辑
        advisedSupport.setMethodMatcher((Method method, Class beanClass) -> true);

        helloService = (HelloService) new JdkDynamicAopProxy(advisedSupport).getProxy();
        helloService.sayHelloWorld();
    }

}
