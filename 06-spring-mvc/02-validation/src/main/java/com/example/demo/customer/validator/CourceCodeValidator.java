package com.example.demo.customer.validator;

import com.example.demo.customer.annotation.CourseCode;
import com.example.demo.customer.dto.Customer;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourceCodeValidator implements ConstraintValidator<CourseCode, String> {
    private String coursePrefix;
    @Override
    public void initialize(CourseCode code) {
        this.coursePrefix = code.value();
    }

    @Override
    public boolean isValid(String courseCode, ConstraintValidatorContext constraintValidatorContext) {
        if(courseCode == null) return false;

        return courseCode.startsWith(this.coursePrefix);
    }
}
