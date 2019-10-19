package com.whatever.school.validators;

import com.whatever.school.annotation.schoolNumber.SchoolNumberValidator;
import com.whatever.school.annotation.schoolNumber.ValidationProperties;
import com.whatever.school.domain.SchoolAccount;
import com.whatever.school.domain.SchoolRole;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class SchoolNumberValidatorTest {

    @InjectMocks
    private SchoolNumberValidator schoolNumberValidator;

    @Mock
    private ValidationProperties validationProperties;

    private static final String studentNumber = "s091449";
    private static String teacherNumber = "t025545";

    private static final String teacherNumberTooShort = "t091";
    private static final String teacherNumberTooLong = "t0914848964684648";
    private static final String studentNumberTooLong = "s0914848964684648";
    private static final String studentNumberTooShort = "s091";

    @Before
    public void setUpProperties(){
        Mockito.when(validationProperties.getStudentPrefix()).thenReturn("s");
        Mockito.when(validationProperties.getTeacherPrefix()).thenReturn("t");
        Mockito.when(validationProperties.getAccountNumberRegexp()).thenReturn("^%s[0-9]{6}$");
    }

    @Test
    public void testValidSchoolAccountStudent(){
        SchoolAccount schoolAccount = new SchoolAccount();
        schoolAccount.setRole(SchoolRole.STUDENT);
        schoolAccount.setNumber(studentNumber);

        assertTrue(schoolNumberValidator.isValid(schoolAccount,null));
    }

    @Test
    public void testInValidNumberTooShortStudent(){
        SchoolAccount schoolAccount = new SchoolAccount();
        schoolAccount.setRole(SchoolRole.STUDENT);
        schoolAccount.setNumber(studentNumberTooShort);

        assertFalse(schoolNumberValidator.isValid(schoolAccount,null));
    }

    @Test
    public void testInValidNumberTooLongStudent(){
        SchoolAccount schoolAccount = new SchoolAccount();
        schoolAccount.setRole(SchoolRole.STUDENT);
        schoolAccount.setNumber(studentNumberTooLong);

        assertFalse(schoolNumberValidator.isValid(schoolAccount,null));
    }

    @Test
    public void testInValidNumberEmptyStudent(){
        SchoolAccount schoolAccount = new SchoolAccount();
        schoolAccount.setRole(SchoolRole.STUDENT);
        schoolAccount.setNumber("");

        assertFalse(schoolNumberValidator.isValid(schoolAccount,null));
    }

    @Test
    public void testTeacherRoleStudent(){
        SchoolAccount schoolAccount = new SchoolAccount();
        schoolAccount.setRole(SchoolRole.TEACHER);
        schoolAccount.setNumber(studentNumber);

        assertFalse(schoolNumberValidator.isValid(schoolAccount,null));
    }

    @Test
    public void testTeacherNumberStudent(){
        SchoolAccount schoolAccount = new SchoolAccount();
        schoolAccount.setRole(SchoolRole.STUDENT);
        schoolAccount.setNumber(teacherNumber);

        assertFalse(schoolNumberValidator.isValid(schoolAccount,null));
    }

    @Test
    public void testNullRoleStudent(){
        SchoolAccount schoolAccount = new SchoolAccount();
        schoolAccount.setRole(null);
        schoolAccount.setNumber(studentNumber);

        assertFalse(schoolNumberValidator.isValid(schoolAccount,null));
    }

    @Test
    public void testNullRoleNullNumberStudent(){
        SchoolAccount schoolAccount = new SchoolAccount();
        schoolAccount.setRole(null);
        schoolAccount.setNumber(null);

        assertFalse(schoolNumberValidator.isValid(schoolAccount,null));
    }

    @Test
    public void testNullNumberStudent(){
        SchoolAccount schoolAccount = new SchoolAccount();
        schoolAccount.setRole(SchoolRole.STUDENT);
        schoolAccount.setNumber(null);

        assertFalse(schoolNumberValidator.isValid(schoolAccount,null));
    }

    @Test
    public void testValidSchoolAccountTeacher(){
        SchoolAccount schoolAccount = new SchoolAccount();
        schoolAccount.setRole(SchoolRole.TEACHER);
        schoolAccount.setNumber(teacherNumber);

        assertTrue(schoolNumberValidator.isValid(schoolAccount,null));
    }

    @Test
    public void testInValidNumberTooShortTeacher(){
        SchoolAccount schoolAccount = new SchoolAccount();
        schoolAccount.setRole(SchoolRole.TEACHER);
        schoolAccount.setNumber(teacherNumberTooShort);

        assertFalse(schoolNumberValidator.isValid(schoolAccount,null));
    }

    @Test
    public void testInValidNumberTooLongTeacher(){
        SchoolAccount schoolAccount = new SchoolAccount();
        schoolAccount.setRole(SchoolRole.TEACHER);
        schoolAccount.setNumber(teacherNumberTooLong);

        assertFalse(schoolNumberValidator.isValid(schoolAccount,null));
    }

    @Test
    public void testInValidNumberEmptyTeacher(){
        SchoolAccount schoolAccount = new SchoolAccount();
        schoolAccount.setRole(SchoolRole.TEACHER);
        schoolAccount.setNumber("");

        assertFalse(schoolNumberValidator.isValid(schoolAccount,null));
    }

    @Test
    public void testStudentRoleTeacher(){
        SchoolAccount schoolAccount = new SchoolAccount();
        schoolAccount.setRole(SchoolRole.STUDENT);
        schoolAccount.setNumber(teacherNumber);

        assertFalse(schoolNumberValidator.isValid(schoolAccount,null));
    }

    @Test
    public void testStudentNumberTeacher(){
        SchoolAccount schoolAccount = new SchoolAccount();
        schoolAccount.setRole(SchoolRole.TEACHER);
        schoolAccount.setNumber(studentNumber);

        assertFalse(schoolNumberValidator.isValid(schoolAccount,null));
    }

    @Test
    public void testNullRoleTeacher(){
        SchoolAccount schoolAccount = new SchoolAccount();
        schoolAccount.setRole(null);
        schoolAccount.setNumber(teacherNumber);

        assertFalse(schoolNumberValidator.isValid(schoolAccount,null));
    }

    @Test
    public void testNullRoleNullNumberTeacher(){
        SchoolAccount schoolAccount = new SchoolAccount();
        schoolAccount.setRole(null);
        schoolAccount.setNumber(null);

        assertFalse(schoolNumberValidator.isValid(schoolAccount,null));
    }

    @Test
    public void testNullNumberTeacher(){
        SchoolAccount schoolAccount = new SchoolAccount();
        schoolAccount.setRole(SchoolRole.TEACHER);
        schoolAccount.setNumber(null);

        assertFalse(schoolNumberValidator.isValid(schoolAccount,null));
    }

}
