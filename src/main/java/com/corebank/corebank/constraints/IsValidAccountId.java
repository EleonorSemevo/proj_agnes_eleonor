package com.corebank.corebank.constraints;

import com.corebank.corebank.constraints.validators.IsValidAccountIdValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD, PARAMETER})
@Retention(RUNTIME)
@Constraint(validatedBy = IsValidAccountIdValidator.class)
@Documented
public @interface IsValidAccountId {
    String message() default "The id does not match any account";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
