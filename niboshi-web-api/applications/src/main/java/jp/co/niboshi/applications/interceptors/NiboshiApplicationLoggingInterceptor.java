package jp.co.niboshi.applications.interceptors;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Aspect
public class NiboshiApplicationLoggingInterceptor {
  @Around("execution(* jp.co.niboshi.applications.usecases..*(..))")
  public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
    log.info(String.format("業務ロジック開始:%s", joinPoint.getSignature()));

    long startTime = System.currentTimeMillis();
    Object proceed = joinPoint.proceed();
    long executionTime = System.currentTimeMillis() - startTime;

    log.info(String.format(
        "業務ロジック終了:%s(処理時間:%dms)", joinPoint.getSignature(), executionTime));
    return proceed;
  }
}
