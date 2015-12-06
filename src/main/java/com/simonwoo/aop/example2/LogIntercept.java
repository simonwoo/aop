package com.simonwoo.aop.example2;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class LogIntercept implements MethodInterceptor {

    @Override
    public Object intercept(Object target, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        //
        Object rev = proxy.invokeSuper(target, args);
        if (method.getName().equals("doSomething")) {
            System.out.println("---Log---");
        }
        return rev;
    }

}
