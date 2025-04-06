package com.orchestration.orchestration.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Aspect
@Component
public class ControllerBeforeAspect {
    private static final Logger log = LoggerFactory.getLogger(ControllerBeforeAspect.class);
    // Define pointcut for all controller methods
    @Pointcut("execution(* com.orchestration.orchestration.controller..*(..))")
    public void allControllerMethods() {}

    // Run before all controller methods
    @Before("allControllerMethods()")
    public void logBeforeExecution(JoinPoint joinPoint) {
        log.info("Entering: {} with arguments = {}",
                joinPoint.getSignature().toShortString(),
                Arrays.toString(joinPoint.getArgs()));
    }
}
