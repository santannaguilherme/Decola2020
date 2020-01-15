package com.example.project.domain.validators;

import java.util.Calendar;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DateValidator implements ConstraintValidator<Datas, Date> {

    @Override
    public boolean isValid(Date value, ConstraintValidatorContext context) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(value);
        int d = cal.get(Calendar.DAY_OF_MONTH);
        Calendar cale = Calendar.getInstance();
        int dayOfMonth = cale.get(Calendar.DAY_OF_MONTH);
        return value != null && ((d < dayOfMonth + 7) && (d > dayOfMonth - 7));
    }
}