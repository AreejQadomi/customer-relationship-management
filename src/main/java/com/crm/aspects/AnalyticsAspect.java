package com.crm.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AnalyticsAspect {

    @Before("com.crm.aspects.Expressions.forDAOPackage()")
    public void performModelsPackageLogging() {
        System.out.println("\n\n=======>> Executing performModelsPackageLogging1 from AnalyticsAspect!!\n");
    }

}
