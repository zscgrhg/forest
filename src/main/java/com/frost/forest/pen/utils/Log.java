package com.frost.forest.pen.utils;

import org.slf4j.LoggerFactory;

/**
 * Created by wenkui on 2015/4/7.
 */
public class Log {
    public static void info(Object o,String msg,Object... e){

        LoggerFactory.getLogger(getClass(o)).info( msg,e);
    }

    public static void debug(Object o,String msg,Object...  e){

        LoggerFactory.getLogger(getClass(o)).debug(msg,e);
    }
    public static void error(Object o,String msg,Object... e){
        LoggerFactory.getLogger(getClass(o)).error(msg,e);
    }

    private static Class getClass(Object o){
        Class c;
        if(o instanceof Class){
            c=(Class)o;
        }else{
            c=o.getClass();
        }
        return c;
    }
}
