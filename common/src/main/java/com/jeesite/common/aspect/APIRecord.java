package com.jeesite.common.aspect;

import java.lang.annotation.*;
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface APIRecord {
    String name() default "";
}
