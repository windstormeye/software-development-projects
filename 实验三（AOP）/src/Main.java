import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
    public static void main(String[] args) {
//        创建SpringIOC容器对象
        ApplicationContext context=new ClassPathXmlApplicationContext("spring-config.xml");
        IOCTest iocTest = (IOCTest)context.getBean("IOCTest");
        iocTest.printIOCName();


    }
}  