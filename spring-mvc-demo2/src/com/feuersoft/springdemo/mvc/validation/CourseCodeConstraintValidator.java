package com.feuersoft.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {
  
  private String coursePrefix;
  
  @CourseCode(value="LUV", message="must start with LUV")
  private String courseCode;

  @Override
  public void initialize(CourseCode theCourseCode) {
    coursePrefix = theCourseCode.value().toUpperCase();
  }

  @Override
  public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) {
    
    boolean result = true;
    if (null != theCode) {
      result = theCode.toUpperCase().startsWith(coursePrefix);
    }
    
    return result;
  }

}
