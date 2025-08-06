package com.bbc876219.lib.spi.annotation;

import androidx.annotation.Keep;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Keep
@Retention(RetentionPolicy.CLASS)
public @interface MultiInstancesServiceImpl {
    String appId() default "";

    Class<?>[] dependencies() default {};

    String[] hookPoints() default {};

    int index() default Integer.MAX_VALUE;

    boolean isCacheIns() default false;

    boolean isHookAfter() default true;

    boolean isHookBefore() default true;

    boolean onlyDebug() default false;

    String[] process() default {};

    int sdkVersion() default 0;

    Class<?> serviceclass() default String.class;
}
