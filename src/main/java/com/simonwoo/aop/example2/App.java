package com.simonwoo.aop.example2;

import net.sf.cglib.proxy.Enhancer;

import com.simonwoo.aop.Business;
import com.simonwoo.aop.IBusiness;

/**
 * cglib will create a subclass with the advice.
 * 
 * @author mac
 *
 */
public class App {

    public static void main(String[] args) {

        Enhancer enhancer = new Enhancer();
        // Sets parent class
        enhancer.setSuperclass(Business.class);
        // Sets the advice
        enhancer.setCallback(new LogIntercept());
        // Create a subclass
        IBusiness business = (IBusiness) enhancer.create();
        business.doSomething();
    }

}
