import com.monitor4all.tinySpring.aop.AspectJExpressionPointcut;
import com.monitor4all.tinySpring.service.HelloService;
import com.monitor4all.tinySpring.service.HelloServiceImpl;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AspectJExpressionPointcutTest {

    /**
     * 类匹配测试
     * @throws Exception
     */
    @Test
    public void testClassFilter() throws Exception {
        String expression = "execution(* com.monitor4all.tinySpring.*.*(..))";
        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        aspectJExpressionPointcut.setExpression(expression);
        boolean matches = aspectJExpressionPointcut.matchers(HelloService.class);
        assertTrue(matches);
    }

    /**
     * 方法匹配测试
     * @throws Exception
     */
    @Test
    public void testMethodMatcher() throws Exception {
        String expression = "execution(* com.monitor4all.tinySpring.service.*.sayHelloWorld(..))";
        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        aspectJExpressionPointcut.setExpression(expression);
        boolean matches = aspectJExpressionPointcut.matchers(HelloServiceImpl.class.getDeclaredMethod("sayHelloWorld"), HelloServiceImpl.class);
        assertTrue(matches);
    }

}
