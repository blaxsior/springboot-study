package com.example.demo.customer.annotation;

import com.example.demo.customer.validator.CourceCodeValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy= CourceCodeValidator.class)
public @interface CourseCode {
    //course code 기본 prefix 설정
    String value() default "LUV";
    // 기본 에러 메시지 설정
    String message() default "must start with LUV";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
