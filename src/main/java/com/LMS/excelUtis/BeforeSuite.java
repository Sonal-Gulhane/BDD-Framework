package com.LMS.excelUtis;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
//Custom Annotation :
@Retention(RUNTIME)
@Target(METHOD)
public @interface BeforeSuite {

}
