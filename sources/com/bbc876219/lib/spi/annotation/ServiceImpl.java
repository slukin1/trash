package com.bbc876219.lib.spi.annotation;

import androidx.annotation.Keep;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Keep
@Retention(RetentionPolicy.CLASS)
public @interface ServiceImpl {
    String appId() default "";

    boolean isCacheIns() default true;

    boolean isInstance() default false;

    boolean isString() default false;

    boolean onlyDebug() default false;

    String[] process() default {};

    int sdkVersion() default 0;

    Class<?> serviceclass() default String.class;
}
