package com.example.annotations;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = CourseTypeValidator.class)
public @interface CourseStatusValidator {
    String message() default "Course Status is not Valid";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
