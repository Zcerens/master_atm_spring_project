package org.example.atmdataproject.controller;

import org.example.atmdataproject.entity.CreditCard;
import org.example.atmdataproject.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/creditCard")
public class CreditCardController {

    @Autowired
    CreditCardService creditCardService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody CreditCard creditCard){
        ResponseEntity<String> responseEntity = null;
        try{
            creditCardService.saveCreditCard(creditCard);
            responseEntity = new ResponseEntity<String>(creditCard.getId() + " is created. ", HttpStatus.OK);
        } catch(Exception e){
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }


}
