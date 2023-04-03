package com.codegym.validator;

import com.codegym.model.Picture;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.Validation;

public class PictureValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Picture.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
        Picture p = (Picture) target;
        if (p.getCode() == null){
            errors.rejectValue("Code", "Khong duoc de trong ten tranh");
        }
    }
}
