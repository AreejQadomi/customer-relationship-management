package com.crm.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Expressions {

    @Pointcut("execution(* com.crm.dao.*.*(..))")
    public void forDAOPackage() {}

    @Pointcut("execution(* com.crm.dao.*.get*(..))")
    public void forDAOPackageGetters() {}

    @Pointcut("execution(* com.crm.dao.*.set*(*))")
    public void forDAOPackageSetters() {}

}
