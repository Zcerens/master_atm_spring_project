package org.example.atmdataproject.service;

import org.example.atmdataproject.entity.BankAccount;
import org.springframework.stereotype.Component;

@Component
public interface BankAccountService {
    public Integer saveBankAccount(BankAccount bankAccount);
    public int getBalance(String accountId);
    public void paraCek(String accountId, int amount);
    public void paraYatir(String accountId, int amount);
}


