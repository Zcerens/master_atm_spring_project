package org.example.atmdataproject.service;

import org.example.atmdataproject.entity.CreditCard;
import org.springframework.stereotype.Component;

@Component
public interface CreditCardService {

    public Integer saveCreditCard(CreditCard creditCard);
}

