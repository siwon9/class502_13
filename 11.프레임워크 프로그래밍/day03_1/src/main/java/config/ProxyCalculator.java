package config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class ProxyCalculator {

    @Pointcut("execution(* exam01..*(..))") // exam01쪽 모든 메서드를 호출해준다.
    public void publicTarget() {}

    // 의미가 명확해서 뒤에 advice 생략
    @Before("publicTarget()")
    public void before(JoinPoint joinPoint){
        System.out.println("Before..");
    }

    @After("publicTarget()")
    public void after(JoinPoint joinPoint) {
        System.out.println("After..");
    }

    @AfterReturning(value="publicTarget()", returning="returnValue")
    public void afterReturning(JoinPoint joinPoint, Object returnValue)  {
        System.out.println("AfterReturning: " + returnValue);
    }

    @AfterThrowing(value="publicTarget()", throwing="e")
    public void afterThrowing(JoinPoint joinPoint, Throwable e){
        System.out.println("afterThrowing");
        e.printStackTrace();
    }

    @Around(value = "publicTarget()")
    public Object process(ProceedingJoinPoint joinPoint) throws Throwable {

//        Signature sig = joinPoint.getSignature(); // 호출된 메서드 정의 정보
//        System.out.println(sig.toLongString());
//
//        Object[] args = joinPoint.getArgs(); // 인수 정보
//        System.out.println(Arrays.toString(args));
//
//        Object obj = joinPoint.getTarget(); // 호출한 메서드를 가지고 있는 객체
//        System.out.println(obj.getClass());

        long stime = System.nanoTime(); // 공통 기능
        try {
            Object result = joinPoint.proceed(); // 핵심 기능 디신 실행 - factorial

            boolean re = false;
            if(!re) {
                throw new RuntimeException("예외 테스트...");
            }

            return result;
        } finally {
             long etime = System.nanoTime(); // 공통 기능
            System.out.printf("걸린시간: %d%n", etime - stime);
        }
    }
}



