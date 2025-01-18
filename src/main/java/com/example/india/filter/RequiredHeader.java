package com.example.india.filter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface RequiredHeader {
    String dcNumber()  default "dcNumber";

    String dcName() default "dcName";

    String[] headerkeys() default {};
}
