package com.frost.forest.gen.anotation.query;

import com.frost.forest.gen.literal.SearchStrategy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by wenkui on 2015/2/9.
 */
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Header {
    String value() default "";
    SearchStrategy searchStrategy() default SearchStrategy.LIKE;
    int order() default 0x7FFFFFFF;
    boolean searchKey() default false;
    boolean updater() default false;
    boolean hidden() default false;
    boolean editable() default true;
}
