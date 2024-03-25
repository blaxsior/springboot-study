package com.example.demo.customer.dto;

import com.example.demo.customer.annotation.CourseCode;
import jakarta.validation.constraints.*;
//import jakarta.validation.constraints.;

public class Customer {
    private String firstName;

    @NotNull(message = "message required")
    @Size(min = 1, message = "message must be > 1")
    private String lastName;
    @NotNull(message = "age is required")
    @Min(value = 0, message = "age must be >= 0")
    @Max(value = 10, message = "age must be <= 10")
    private Integer age;

    @NotNull(message ="postal code is required")
    @Pattern(regexp = "^[a-zA-Z0-9]{5,6}", message="only 5 or 6 chars/digits")
    private String postalCode;

    @CourseCode
    private String courseCode;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", postalCode='" + postalCode + '\'' +
                ", courseCode='" + courseCode + '\'' +
                '}';
    }
}
