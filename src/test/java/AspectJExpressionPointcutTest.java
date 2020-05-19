import com.monitor4all.tinySpring.aop.AspectJExpressionPointcut;
import com.monitor4all.tinySpring.service.HelloService;
import com.monitor4all.tinySpring.service.HelloServiceImpl;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AspectJExpressionPointcutTest {

    @Test
    public void testClassFilter() throws Exception {
        String expression = "execution(* com.titizz.simulation.toyspring.*.*(..))";
        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        aspectJExpressionPointcut.setExpression(expression);
        boolean matches = aspectJExpressionPointcut.matchers(HelloService.class);
        assertTrue(matches);
    }

    @Test
    public void testMethodMatcher() throws Exception {
        String expression = "execution(* com.titizz.simulation.toyspring.*.sayHelloWorld(..))";
        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        aspectJExpressionPointcut.setExpression(expression);
        boolean matches = aspectJExpressionPointcut.matchers(
                HelloServiceImpl.class.getDeclaredMethod("sayHelloWorld"), HelloServiceImpl.class);
        assertTrue(matches);
    }

}
