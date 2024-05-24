package org.example.atmdataproject.service;

import jakarta.transaction.Transactional;
import org.example.atmdataproject.entity.BankAccount;
import org.example.atmdataproject.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Service
public class BankAccountServiceImp implements BankAccountService {

    @Autowired
    BankAccountRepository bankAccountRepository;

    @Override
    @Transactional
    public Integer saveBankAccount(BankAccount bankAccount) {
        return bankAccountRepository.save(bankAccount).getAccountId();
            }

    @Override
    @Transactional
    public int getBalance(String accountId) {
        BankAccount bankAccount = bankAccountRepository.findById(accountId).orElse(null);
        if (bankAccount != null) {
            return bankAccount.getBalance();
        } else {
            return 0;
        }

    }

    @Override
    @Transactional
    public void paraCek(String accountId, int amount) {
        BankAccount bankAccount = bankAccountRepository.findById(accountId).orElse(null);
        if (bankAccount != null) {

            int newBalance = bankAccount.getBalance() - amount;
            bankAccount.setBalance(newBalance);
            bankAccount.setIslemYapilanParaTutari(amount);

            bankAccountRepository.save(bankAccount); // Save the updated bank account

        } else {
            // Bank account not found
        }
    }

    @Override
    @Transactional
    public void paraYatir(String accountId, int amount) {
        BankAccount bankAccount = bankAccountRepository.findById(accountId).orElse(null);
        if(bankAccount!=null){
            int newBalance = bankAccount.getBalance() + amount;
            bankAccount.setBalance(newBalance);
            bankAccount.setIslemYapilanParaTutari(amount);

            bankAccountRepository.save(bankAccount);
        }
    }


}
