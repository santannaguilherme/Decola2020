package com.example.project.domain.validators;

import java.util.Calendar;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DateValidator implements ConstraintValidator<Datas, Date> {

    @Override
    public boolean isValid(Date value, ConstraintValidatorContext context) {
        Date hoje = new Date();
        int dias = 7*24*60*60*1000;

        Date limiteInferior = new Date(hoje.getTime()-dias);
        Date limiteSuperior = new Date(hoje.getTime()+dias);
        
        return value != null && 
                value.getTime()>= limiteInferior.getTime() &&
                value.getTime() <= limiteSuperior.getTime();
    }
}