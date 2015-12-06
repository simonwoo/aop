package com.simonwoo.aop.example3;

import javassist.ClassPool;
import javassist.Loader;

public class App {

    public static void main(String[] args) throws Throwable {
        //
        ClassPool cp = ClassPool.getDefault();
        Loader loader = new Loader();
        loader.addTranslator(cp, new MyTranslator());
        loader.run("com.simonwoo.aop.example3.MyBusiness", args);
    }

}
