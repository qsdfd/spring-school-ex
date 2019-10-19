package com.whatever.school.annotation.schoolNumber;

import org.springframework.beans.factory.annotation.Value;

public class ValidationProperties {

    @Value( "${studentPrefix}" )
    private String studentPrefix;

    @Value( "${teacherPrefix}" )
    private String teacherPrefix;

    @Value( "${accountNumber.regexp}" )
    private String accountNumberRegexp;

    public String getStudentPrefix() {
        return studentPrefix;
    }

    public String getTeacherPrefix() {
        return teacherPrefix;
    }

    public String getAccountNumberRegexp() {
        return accountNumberRegexp;
    }
}
