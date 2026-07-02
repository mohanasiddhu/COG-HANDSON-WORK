package com.spring.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * LoggingAspect - Cross-cutting concern for logging This aspect implements
 * logging using Spring AOP
 *
 * Pointcuts: - service execution() - execution of methods in service package
 *
 * Advice types: - @Before: Log method name and parameters before execution -
 *
 * @After: Log completion after execution - @Around: Log execution time -
 * @AfterReturning: Log return value - @AfterThrowing: Log exceptions
 */
@Aspect
public class LoggingAspect {

    /**
     * Pointcut definition for all methods in UserService
     */
    @Pointcut("execution(* com.spring.aop.services.UserService.*(..))")
    public void userServiceMethods() {
    }

    /**
     * Before advice - executes before method execution Logs method name and
     * parameters
     */
    @Before("userServiceMethods()")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("\n========== BEFORE ADVICE ==========");
        System.out.println("Method Name: " + joinPoint.getSignature().getName());
        System.out.println("Method Class: " + joinPoint.getSignature().getDeclaringTypeName());

        Object[] args = joinPoint.getArgs();
        if (args.length > 0) {
            System.out.print("Arguments: ");
            for (Object arg : args) {
                System.out.print(arg + " ");
            }
            System.out.println();
        }
        System.out.println("Timestamp: " + System.currentTimeMillis());
    }

    /**
     * After advice - executes after method execution (regardless of outcome)
     */
    @After("userServiceMethods()")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("\n========== AFTER ADVICE ==========");
        System.out.println("Method: " + joinPoint.getSignature().getName() + " - Completed");
        System.out.println("Timestamp: " + System.currentTimeMillis());
    }

    /**
     * AfterReturning advice - executes after method returns successfully
     * Captures the return value
     */
    @AfterReturning(pointcut = "userServiceMethods()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("\n========== AFTER RETURNING ADVICE ==========");
        System.out.println("Method: " + joinPoint.getSignature().getName());
        if (result != null) {
            System.out.println("Returned Value: " + result);
        }
    }

    /**
     * AfterThrowing advice - executes if method throws an exception
     */
    @AfterThrowing(pointcut = "userServiceMethods()", throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable exception) {
        System.out.println("\n========== AFTER THROWING ADVICE ==========");
        System.out.println("Method: " + joinPoint.getSignature().getName());
        System.out.println("Exception occurred: " + exception.getMessage());
        System.out.println("Exception Type: " + exception.getClass().getSimpleName());
    }

    /**
     * Around advice - wraps method execution Logs execution time and controls
     * method invocation
     */
    @Around("userServiceMethods()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("\n========== AROUND ADVICE - START ==========");
        long startTime = System.currentTimeMillis();

        System.out.println("Method: " + joinPoint.getSignature().getName());
        System.out.println("Starting execution at: " + startTime);

        Object result = null;
        try {
            // Proceed with method execution
            result = joinPoint.proceed();
        } catch (Throwable e) {
            System.out.println("Exception in around advice: " + e.getMessage());
            throw e;
        }

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        System.out.println("\n========== AROUND ADVICE - END ==========");
        System.out.println("Method: " + joinPoint.getSignature().getName());
        System.out.println("Execution Time: " + executionTime + " ms");

        return result;
    }
}
