package com.chrischlin.spring.learn.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("@annotation(Loggable)")
    public void executeLogging(){}

    @Before("executeLogging()")
    public void logMethodCall(JoinPoint joinPoint) {
        StringBuilder msgBuilder = new StringBuilder("Method: ");
        msgBuilder.append(joinPoint.getSignature().getName());
        Object[] args = joinPoint.getArgs();
        if (args != null && args.length > 0) {
            msgBuilder.append("args=[ ");
            Arrays.asList(args).forEach(arg -> {
                msgBuilder.append(arg).append(", ");
            });

            msgBuilder.append("]");
        }
        LOGGER.info(msgBuilder.toString());
    }
}
