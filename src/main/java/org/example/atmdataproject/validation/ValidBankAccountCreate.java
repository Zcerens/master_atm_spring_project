package org.example.atmdataproject.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Target(TYPE)
@Retention(RUNTIME)
@Constraint(validatedBy = { BankAccountCreateValidator.class })
public @interface ValidBankAccountCreate {
    String message() default "message";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
