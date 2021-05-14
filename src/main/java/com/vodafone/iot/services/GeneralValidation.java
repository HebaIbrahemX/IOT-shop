package com.vodafone.iot.services;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidationException;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.vodafone.iot.dto.DTO;

import org.springframework.stereotype.Component;

@Component
public class GeneralValidation {

    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator =factory.getValidator();

    public void validateData(DTO data){
        Set<ConstraintViolation<DTO>> violations =validator.validate(data);
        if(!violations.isEmpty()){
            for(ConstraintViolation<DTO>violation :violations){
            throw new ValidationException("message:- "+violation.getMessage());
            }
        }
    }
    
}
