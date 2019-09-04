package com.clark.kotlin_demo;

import java.io.ObjectStreamClass;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created By Clark
 * Description :
 *
 * @date 2019/5/20.
 */
public class JavaCompareKT {
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void doWhatever() {
        try {
            Method doWhatever = getClass().getDeclaredMethod("doWhatever");
            invocationHandler.invoke(this, doWhatever, null);
            Method toString = getClass().getDeclaredMethod("toString");
            invocationHandler.invoke(this, toString, null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }


    }

    private InvocationHandler invocationHandler = new InvocationHandler() {
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (method.getDeclaringClass() == Object.class) {
                System.out.println("Object方法 直接调用 Name: " + method.getName());
            } else {
                System.out.println("非Object方法 Name: " + method.getName());
            }
            return null;
        }
    };
}
