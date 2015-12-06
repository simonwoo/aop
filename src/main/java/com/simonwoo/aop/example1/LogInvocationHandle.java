package com.simonwoo.aop.example1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogInvocationHandle implements InvocationHandler {
    private Object target;

    public LogInvocationHandle(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object rev = method.invoke(target, args);
        if (method.getName().equals("doSomething")) {
            System.out.println("----Log---");
        }
        return rev;
    }

}
