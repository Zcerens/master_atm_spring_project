package org.example.atmdataproject.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import org.example.atmdataproject.entity.BankAccount;

public class BankAccountCreateValidator implements ConstraintValidator<ValidBankAccountCreate, BankAccount> {

    private static final String ENTER_THE_ACCOUNT_HOLDER_ID = "Hesap sahibi id'si giriniz";
    private static final String ENTER_THE_ACCOUNT_HOLDER_ID_NOT_ZERO = "Hesap sahibi id'si 0 olamaz";

    @Override
    public void initialize(ValidBankAccountCreate constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(BankAccount bankAccount, ConstraintValidatorContext constraintValidatorContext) {
        if (bankAccount == null || bankAccount.getUser() == null || bankAccount.getUser().getId() == null) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(ENTER_THE_ACCOUNT_HOLDER_ID)
                    .addPropertyNode("user.id")
                    .addConstraintViolation();
            return false;
        }

        if(bankAccount.getUser().getId() == 0){
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(ENTER_THE_ACCOUNT_HOLDER_ID_NOT_ZERO)
                    .addPropertyNode("user.id")
                    .addConstraintViolation();
            return false;
        }

        // diğer türlü id her zaman 0 dan farklı
        return true;
    }
}
