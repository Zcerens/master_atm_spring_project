package org.example.atmdataproject.controller;

import jakarta.validation.Valid;
import org.example.atmdataproject.entity.BankAccount;
import org.example.atmdataproject.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class BankAccountController {

    @Autowired
    private BankAccountService bankAccountService;

    @PostMapping("/createAccount")
    public ResponseEntity<String> save(@Valid @RequestBody BankAccount bankAccount) {
        ResponseEntity<String> responseEntity = null;
        try {
            Integer integer = Integer.valueOf(bankAccountService.saveBankAccount(bankAccount));
            responseEntity = new ResponseEntity<String>("Account " + integer + " created", HttpStatus.OK);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;

    }

    @GetMapping("/getBalance/{accountId}")
    public int getBalance(@PathVariable String accountId) {
        int responseEntity = 0;

        responseEntity = bankAccountService.getBalance(accountId);

        return responseEntity;
    }

    @PutMapping("/paraCek")
    public ResponseEntity<String> paraCek(@RequestBody BankAccount bankAccount) {

        ResponseEntity<String> responseEntity = null;
        bankAccountService.paraCek(String.valueOf(bankAccount.getAccountId()), bankAccount.getIslemYapilanParaTutari());

        try {
            responseEntity = new ResponseEntity<String>("Çekilen para:  " + bankAccount.getIslemYapilanParaTutari(), HttpStatus.OK);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @PutMapping("/paraYatir")
    public ResponseEntity<String> paraYatir(@RequestBody BankAccount bankAccount){

        ResponseEntity<String> responseEntity = null;
        bankAccountService.paraYatir(String.valueOf(bankAccount.getAccountId()), bankAccount.getIslemYapilanParaTutari());

        try{
            responseEntity = new ResponseEntity<String>("Yatırılan para: " + bankAccount.getIslemYapilanParaTutari(), HttpStatus.OK);

        }catch(Exception e){
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);

        }
        return responseEntity;
    }
}

//http://localhost:8080/paraCek
    /*{
        "accountId": "1",
        "islemYapilanParaTutari" : 10
    }*/
//http://localhost:8080/getBalance/3

//http://localhost:8080/createAccount