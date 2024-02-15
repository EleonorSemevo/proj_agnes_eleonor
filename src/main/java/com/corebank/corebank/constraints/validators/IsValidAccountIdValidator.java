package com.corebank.corebank.constraints.validators;

import com.corebank.corebank.constraints.IsValidAccountId;
import com.corebank.corebank.repositories.AccountRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IsValidAccountIdValidator implements
        ConstraintValidator<IsValidAccountId, Long> {

    private final AccountRepository accountRepository;

    public IsValidAccountIdValidator(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void initialize(IsValidAccountId constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        return accountRepository.findById(value).isPresent();
    }
}
