package org.api.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * AOP实现
 */
@Component
@Aspect
public class Notice {
    @Before(value = "execution(* org.api.service.impl.UserServiceImpl.userList(..))")
    private void print(){
        System.err.println("前置通知");
    }
}
