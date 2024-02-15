package com.corebank.corebank.constraints;

import com.corebank.corebank.constraints.validators.IsValidClientIdValidator;
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
@Constraint(validatedBy = IsValidClientIdValidator.class)
@Documented
public @interface IsValidClientId {
    String message() default "Some id does not match any client";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
