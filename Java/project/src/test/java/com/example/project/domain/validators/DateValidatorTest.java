package com.example.project.domain.validators;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import static org.junit.Assert.assertFalse;


import javax.validation.ConstraintValidatorContext;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * PhoneValidatorTest
 */
@RunWith(MockitoJUnitRunner.class)
public class DateValidatorTest {

    @Mock
    ConstraintValidatorContext constraintValidatorContext;

    DateValidator dateValidator;

    @Before
    public void setUp() {

        dateValidator = new DateValidator();

    }

    @Test
    public void should_NotBeValid_When7DaysAfter() {
        Date hoje = new Date();
        int dias = 8*24*60*60*1000;
        hoje.setTime(hoje.getTime()+dias);
        
        assertFalse(dateValidator.isValid(hoje, constraintValidatorContext));
    }
    @Test
    public void should_NotBeValid_When7DaysBefore() {
        Date hoje = new Date();
        int dias = 8*24*60*60*1000;
        hoje.setTime(hoje.getTime()-dias);
        assertFalse(dateValidator.isValid(hoje, constraintValidatorContext));
    }

    @Test
    public void should_NotBeValid_WhenNull() {
        assertFalse(dateValidator.isValid(null, constraintValidatorContext));
    }

    @Test
    public void should_BeValid_WhenBetween7Days() {
        Date hoje = new Date();
        int dias = 7*24*60*60*1000-1;
        hoje.setTime(hoje.getTime()-dias);
        assertTrue(dateValidator.isValid(hoje, constraintValidatorContext));
        hoje.setTime(hoje.getTime()+dias);
        assertTrue(dateValidator.isValid(hoje, constraintValidatorContext));
    }

    @Test
    public void should_BeValid_WhenToday() {
        Date hoje = new Date();       
        assertTrue(dateValidator.isValid(hoje, constraintValidatorContext));
    }

} 