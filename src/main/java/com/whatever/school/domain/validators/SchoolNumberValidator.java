package com.whatever.school.domain.validators;

import com.whatever.school.domain.SchoolAccount;
import com.whatever.school.domain.SchoolRole;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SchoolNumberValidator implements ConstraintValidator<ValidSchoolNumber, SchoolAccount> {
    @Override
    public void initialize(ValidSchoolNumber constraintAnnotation) {

    }

    @Override
    public boolean isValid(SchoolAccount schoolAccount, ConstraintValidatorContext constraintValidatorContext) {
        String prefix = "";

        if (schoolAccount.getRole().equals(SchoolRole.STUDENT)) {
            prefix = "s";
        }

        if (schoolAccount.getRole().equals(SchoolRole.TEACHER)) {
            prefix = "t";
        }

        String regex = String.format("^%s[0-9]{6}$", prefix);

        return schoolAccount.getNumber().matches(regex);
    }
}
