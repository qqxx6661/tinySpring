import com.monitor4all.tinySpring.simple.aop.*;
import com.monitor4all.tinySpring.service.HelloService;
import com.monitor4all.tinySpring.service.HelloServiceImpl;
import org.junit.Test;

public class SimpleAOPTest {

    @Test
    public void getProxy() throws Exception {

        // 1. 创建一个 MethodInvocation 实现类 (切面逻辑写在这里)
        MethodInvocation logTask = new LogTask();

        // 2 创建一个正常实现类HelloServiceImpl
        HelloServiceImpl helloServiceImpl = new HelloServiceImpl();

        // 3. 创建一个 BeforeAdvice 传入HelloServiceImpl类和MethodInvocation类
        Advice aroundAdvice = new AroundAdvice(helloServiceImpl, logTask, logTask);

        // 4. 为目标实现类对象HelloServiceImpl生成代理
        HelloService helloServiceImplProxy = (HelloService) SimpleAOP.getProxy(helloServiceImpl,aroundAdvice);

        // 5. 成功执行被代理的类HelloServiceImpl
        helloServiceImplProxy.sayHelloWorld();
    }
}
