package com.whatever.school.annotation.schoolNumber;

import com.whatever.school.domain.SchoolAccount;
import com.whatever.school.domain.SchoolRole;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SchoolNumberValidator implements ConstraintValidator<ValidSchoolNumber, SchoolAccount> {

    @Autowired
    private ValidationProperties validationProperties;

    @Override
    public void initialize(ValidSchoolNumber constraintAnnotation) {

    }

    @Override
    public boolean isValid(SchoolAccount schoolAccount, ConstraintValidatorContext constraintValidatorContext) {
        String prefix = null;

        SchoolRole role = schoolAccount.getRole();
        String accountNumer = schoolAccount.getNumber();

        if(role == null || accountNumer == null) return false;

        switch (role) {
            case STUDENT:
                prefix = validationProperties.getStudentPrefix();
                break;
            case TEACHER:
                prefix = validationProperties.getTeacherPrefix();
                break;
        }

        String regex = String.format(validationProperties.getAccountNumberRegexp(), prefix);

        return accountNumer.matches(regex);
    }
}
