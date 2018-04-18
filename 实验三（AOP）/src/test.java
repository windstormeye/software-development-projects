import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {

    @Test
    public void AOPTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        AOPTest aopTest = (AOPTest) applicationContext.getBean("AOPTest");
        aopTest.AOPTest();
    }

}
