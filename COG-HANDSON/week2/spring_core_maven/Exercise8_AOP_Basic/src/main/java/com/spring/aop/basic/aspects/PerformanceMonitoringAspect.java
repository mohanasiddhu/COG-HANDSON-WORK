package com.spring.aop.basic.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Performance Monitoring Aspect Monitors and logs performance metrics for
 * service methods
 */
@Aspect
public class PerformanceMonitoringAspect {

    /**
     * Pointcut for all BankAccountService methods
     */
    @Pointcut("execution(* com.spring.aop.basic.services.BankAccountService.*(..))")
    public void bankServiceMethods() {
    }

    /**
     * Around advice: Measures and logs execution time
     */
    @Around("bankServiceMethods()")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        long startTime = System.currentTimeMillis();

        System.out.println("\n[Performance] Starting method: " + methodName);

        Object result = null;
        try {
            result = joinPoint.proceed();
        } finally {
            long endTime = System.currentTimeMillis();
            long executionTime = endTime - startTime;

            System.out.println("[Performance] Method '" + methodName + "' took " + executionTime + "ms");

            // Log warning if execution is slow
            if (executionTime > 100) {
                System.out.println("[Performance WARNING] Method execution was slow: " + executionTime + "ms");
            }
        }

        return result;
    }

    /**
     * Before advice: Validates input parameters
     */
    @Before("bankServiceMethods()")
    public void validateInputs(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        System.out.println("[Validation] Validating inputs for method: " + methodName);

        // Validate non-null parameters
        for (int i = 0; i < args.length; i++) {
            if (args[i] == null) {
                System.out.println("[Validation WARNING] Parameter " + i + " is null!");
            }
        }

        // Validate account IDs
        if (args.length > 0 && args[0] instanceof String) {
            String accountId = (String) args[0];
            if (!accountId.startsWith("ACC")) {
                System.out.println("[Validation WARNING] Invalid account ID format: " + accountId);
            }
        }
    }

    /**
     * AfterReturning advice: Logs successful transaction
     */
    @AfterReturning(pointcut = "bankServiceMethods()", returning = "result")
    public void logSuccessfulOperation(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("[Transaction] ✓ Operation completed: " + methodName);

        if (result instanceof Double) {
            System.out.println("[Transaction] Result: $" + result);
        }
    }

    /**
     * AfterThrowing advice: Handles exceptions
     */
    @AfterThrowing(pointcut = "bankServiceMethods()", throwing = "exception")
    public void handleException(JoinPoint joinPoint, Throwable exception) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("[Error] ✗ Exception in method: " + methodName);
        System.out.println("[Error] Exception type: " + exception.getClass().getSimpleName());
        System.out.println("[Error] Message: " + exception.getMessage());
    }
}

/**
 * Security Auditing Aspect Audits sensitive operations
 */
@Aspect
class SecurityAuditingAspect {

    /**
     * Pointcut for withdrawal and transfer operations
     */
    @Pointcut("execution(* com.spring.aop.basic.services.BankAccountService.withdraw(..)) || "
            + "execution(* com.spring.aop.basic.services.BankAccountService.transfer(..))")
    public void securitySensitiveMethods() {
    }

    /**
     * Before advice: Audit sensitive operations
     */
    @Before("securitySensitiveMethods()")
    public void auditSensitiveOperation(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        System.out.println("\n[AUDIT] Sensitive operation detected: " + methodName);
        System.out.println("[AUDIT] Timestamp: " + System.currentTimeMillis());

        if (args.length > 0) {
            System.out.print("[AUDIT] Parameters: ");
            for (Object arg : args) {
                System.out.print(arg + " ");
            }
            System.out.println();
        }
    }

    /**
     * After advice: Log completion of sensitive operations
     */
    @After("securitySensitiveMethods()")
    public void logSensitiveOperationCompletion(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("[AUDIT] Sensitive operation completed: " + methodName + "\n");
    }
}
