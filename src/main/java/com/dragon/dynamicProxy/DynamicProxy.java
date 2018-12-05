package com.dragon.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * User: dengshenyan
 * Time: 2018-05-11 16:54
 */
public class DynamicProxy implements InvocationHandler {

    // 代理的真实对象
    private Object target;

    public DynamicProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 在代理真实对象前做一些动作
        System.out.println("before rent house");

        System.out.println("Method:" + method);
        // 当代理对象调用真实对象的方法时，其会自动的跳转到代理对象关联的handle对象的invoke方法来进行调用
        method.invoke(target, args);

        // 在代理真实对象后做一些动作
        System.out.println("after rent house");

        return null;
    }
}
