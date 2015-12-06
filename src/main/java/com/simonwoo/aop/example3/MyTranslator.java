package com.simonwoo.aop.example3;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;
import javassist.Translator;

public class MyTranslator implements Translator {

    @Override
    public void onLoad(ClassPool pool, String classname) throws NotFoundException, CannotCompileException {
        //
        if (!classname.equals("com.simonwoo.aop.Business")) {
            return;
        }

        CtClass cc = pool.get(classname);
        CtMethod method = cc.getDeclaredMethod("doSomething");
        method.insertBefore("{System.out.println(\"---Log---\");}");
    }

    @Override
    public void start(ClassPool pool) throws NotFoundException, CannotCompileException {
        // TODO Auto-generated method stub

    }

}
