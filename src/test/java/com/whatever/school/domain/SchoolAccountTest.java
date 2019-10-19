package com.whatever.school.domain;

import com.whatever.school.Application;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;


//@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes =  Application.class)
public class SchoolAccountTest {

    private static Validator validator;

    @Before
    public void setupValidatorInstance() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testDefaultObjectViolates() {
        SchoolAccount schoolAccount = new SchoolAccount();
        Set<ConstraintViolation<SchoolAccount>> violations = validator.validate(schoolAccount);
        Assert.assertFalse(violations.isEmpty());
    }

    @Test
    public void testValidObject() {
        SchoolAccount schoolAccount = new SchoolAccount();
        schoolAccount.setNumber("s091449");
        schoolAccount.setRole(SchoolRole.STUDENT);
        schoolAccount.setEmail("jan.bob@gmail.com");
        schoolAccount.setFirstName("Jan");
        schoolAccount.setLastName("Bob");
        Set<ConstraintViolation<SchoolAccount>> violations = validator.validate(schoolAccount);
        Assert.assertTrue(violations.isEmpty());
    }

}