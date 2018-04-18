import org.aspectj.lang.ProceedingJoinPoint;

public class AOPMethon {

    //前置增强
    public void before(){
        System.out.println("前置增强........");
    }

    //后置增强
    public void after(){
        System.out.println("后置增强........");
    }

    //环绕增强
    public void arround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //方法之前执行的代码
        System.out.println("环绕增强 方法之前执行........");

        //执行被增强的方法
        proceedingJoinPoint.proceed();

        //方法之后执行的代码
        System.out.println("环绕增强 方法之后执行........");
    }

}
