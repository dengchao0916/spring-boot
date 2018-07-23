package com.dengchao.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author : Administrator
 * @Description :
 * @date : 下午 2:45  2018/7/23 0023
 */
@Aspect
@Component
public class HttpAspect {
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.dengchao.controller.GirlController.*(..))")
    public void log() {

    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url
        logger.info("url = {}", request.getRequestURL());
        //method
        logger.info("method = {}", request.getMethod());
        //ip
        logger.info("ip = {}", request.getRemoteAddr());
        //类方法
        logger.info("class method = {}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        //参数
        logger.info("args = {}", joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter() {
        System.out.println("doAfter-------------------");
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        if(null != object){
            logger.info("response = {}", object.toString());
        }

    }
}
