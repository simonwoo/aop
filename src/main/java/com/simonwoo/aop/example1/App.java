package com.simonwoo.aop.example1;

import java.lang.reflect.Proxy;

import com.simonwoo.aop.Business;
import com.simonwoo.aop.IBusiness;

public class App
{
    public static void main(String[] args)
    {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        //
        Class[] proxyInterfaces = new Class[] { IBusiness.class };
        // Contains the advice and pointcut in the invocationHandle
        LogInvocationHandle handler = new LogInvocationHandle(new Business());
        ClassLoader classLoader = App.class.getClassLoader();

        // Class<?> proxyClass = Proxy.getProxyClass(classLoader, proxyInterfaces);
        // IBussiness bussiness= (IBussiness) proxyClass.getConstructor(InvocationHandler.class).newInstance(handler);
        IBusiness bussiness = (IBusiness) Proxy.newProxyInstance(classLoader, proxyInterfaces, handler);
        bussiness.doSomething();

    }
}

// getProxyClass generate the code below:

// public final class $Proxy0 extends Proxy implements IBussiness{
// private static Method m1;
// private static Method m3;
// private static Method m2;
// private static Method m0;
//
// public $Proxy0(InvocationHandler paramInvocationHandler)
// {
// super(paramInvocationHandler);
// }
//
// public final boolean equals(Object paramObject)
// {
// try
// {
// return ((Boolean)this.h.invoke(this, m1, new Object[] { paramObject })).booleanValue();
// }
// catch (Error|RuntimeException localError)
// {
// throw localError;
// }
// catch (Throwable localThrowable)
// {
// throw new UndeclaredThrowableException(localThrowable);
// }
// }
//
// public final void doSomething()
// {
// try
// {
// this.h.invoke(this, m3, null);
// return;
// }
// catch (Error|RuntimeException localError)
// {
// throw localError;
// }
// catch (Throwable localThrowable)
// {
// throw new UndeclaredThrowableException(localThrowable);
// }
// }
//
// public final String toString()
// {
// try
// {
// return (String)this.h.invoke(this, m2, null);
// }
// catch (Error|RuntimeException localError)
// {
// throw localError;
// }
// catch (Throwable localThrowable)
// {
// throw new UndeclaredThrowableException(localThrowable);
// }
// }
//
// public final int hashCode()
// {
// try
// {
// return ((Integer)this.h.invoke(this, m0, null)).intValue();
// }
// catch (Error|RuntimeException localError)
// {
// throw localError;
// }
// catch (Throwable localThrowable)
// {
// throw new UndeclaredThrowableException(localThrowable);
// }
// }
//
// static
// {
// try
// {
// m1 = Class.forName("java.lang.Object").getMethod("equals", new Class[] { Class.forName("java.lang.Object") });
// m3 = Class.forName("com.simonwoo.aop.example1.IBussiness").getMethod("doSomething", new Class[0]);
// m2 = Class.forName("java.lang.Object").getMethod("toString", new Class[0]);
// m0 = Class.forName("java.lang.Object").getMethod("hashCode", new Class[0]);
// return;
// }
// catch (NoSuchMethodException localNoSuchMethodException)
// {
// throw new NoSuchMethodError(localNoSuchMethodException.getMessage());
// }
// catch (ClassNotFoundException localClassNotFoundException)
// {
// throw new NoClassDefFoundError(localClassNotFoundException.getMessage());
// }
// }
// }
