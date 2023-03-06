package com.crm.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class LoggingAspect {

    // Add related Advices for logging

    /* Pointcut Expressions:
     * Matching patterns:
     * - Match only method name deleteCustomer in CustomerDAO class:
     *      @Before("execution(public void com.crm.dao.CustomerDAO.deleteCustomer(int))")
     * - Match any method name deleteCustomer in any class:
     *      @Before("execution(public void deleteCustomer(int))")
     * - Match on method names using wildcards:
     *      @Before("execution(public void delete*(int))") // starting with delete in any class
     *      @Before("execution(* getCustomer(int))") // any return type, 'public' modifier is optional
     *
     * - Match a method with no arguments
     *      ()
     * - Match a method with one argument of any type
     *      (*)
     * - Match a method with 0 or more arguments of any type
     *      (..)
     *      (com.crm.models.Customer, ..) // match Customer Obj. followed by any number of args.
     * - Match a param type - should be full qualified classname
     *      (com.crm.models.Customer)
     *
     * - Match in a specific package!
     *      * packagePath.*.*(..) // matches in the package, in any class, in any method return type, with any parameters
     *      * packagePath.*.add*(..) // matches in the package, in any class, in any method return type and starts with 'add', with any parameters
     */
    @Before("execution(public void deleteCustomer(int))")
    public void beforeDeleteCustomerAdvice(JoinPoint joinPoint) {
        System.out.println("\n\n=======>> Executing before deleteCustomer!!\n\n");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("\n\n=======>> MethodSig: " + methodSignature);
        System.out.println("\n\n=======>> Args: ");
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println(arg);
        }
    }


    // Reuse pointcut expression
    // Apply the pointcut to multiple advices
    @Before("com.crm.aspects.Expressions.forDAOPackage()")
    public void performModelsPackageLogging() {
        System.out.println("\n\n=======>> Executing performModelsPackageLogging1 from LoggingAspect!!\n");
    }

    // Combining pointcuts
     /* What if we have multiple pointcut expressions that we want to apply to a single advice?
     Ex: Apply to all methods in the package EXCEPT Getter/Setter methods?
     @Before("expression1() && expression2()")
     @Before("expression1() || expression2()")
     @Before("expression1() && !expression2()")
     */

    @Before("com.crm.aspects.Expressions.forDAOPackage() && !(com.crm.aspects.Expressions.forDAOPackageGetters() || com.crm.aspects.Expressions.forDAOPackageSetters())")
    public void myBeforeMethod(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("\n\n=======>> MethodSig: " + methodSignature);
        System.out.println("\n\n=======>> Apply before all methods in the package EXCEPT Getter/Setter methodss!!\n\n");
    }

}
