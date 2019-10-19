package com.whatever.school.annotation.schoolNumber;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {SchoolNumberValidator.class})
public @interface ValidSchoolNumber {

    String message() default "{SchoolNumber.Invalid}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
