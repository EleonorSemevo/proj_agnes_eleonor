package com.corebank.corebank.constraints.validators;


import com.corebank.corebank.constraints.IsValidClientId;
import com.corebank.corebank.repositories.ClientRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class IsValidClientIdValidator implements ConstraintValidator<IsValidClientId, List<Long>> {

    private final ClientRepository clientRepository;

    public IsValidClientIdValidator(ClientRepository userRepository) {
        this.clientRepository = userRepository;
    }

    @Override
    public void initialize(IsValidClientId constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(List<Long> value, ConstraintValidatorContext context) {
        for(int i=0;i<value.size();i++){
            if(!clientRepository.findById(value.get(i)).isPresent()){
                return  false;
            }
        }
        return true;
                //userRepository.findById(value).isPresent();
    }
}