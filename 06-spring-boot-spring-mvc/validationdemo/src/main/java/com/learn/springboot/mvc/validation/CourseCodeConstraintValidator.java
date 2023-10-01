package com.learn.springboot.mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private String coursePrefix;

    @Override
    public void initialize(CourseCode theCourseCode) {
        // accessing the value passed in @CourseCode annotation
        coursePrefix = theCourseCode.value(); // actually access the attribute value for that given annotation

    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) {

        if(theCode != null) {
            return theCode.startsWith(coursePrefix);
        } else {
            return true;
        }

    }
}
