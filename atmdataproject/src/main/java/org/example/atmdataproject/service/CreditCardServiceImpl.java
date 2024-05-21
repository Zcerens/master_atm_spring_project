package org.example.atmdataproject.service;

import jakarta.transaction.Transactional;
import org.example.atmdataproject.entity.CreditCard;
import org.example.atmdataproject.repository.CreditCardRepository;
import org.example.atmdataproject.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.Random;

@Configuration
public class CreditCardServiceImpl implements CreditCardService {

    @Autowired
    CreditCardRepository creditCardRepository;

    @Override
    @Transactional
    public Integer saveCreditCard(CreditCard creditCard) {
        double faizOrani = 0;

        if (creditCard.getTaksitSayisi() > 0 && creditCard.getTaksitSayisi() <= 3) {
            faizOrani = 0.1;
        } else if (creditCard.getTaksitSayisi() > 3 && creditCard.getTaksitSayisi() <= 6) {
            faizOrani = 0.3;
        } else if (creditCard.getTaksitSayisi() > 6 && creditCard.getTaksitSayisi() <= 9) {
            faizOrani = 0.5;
        } else if (creditCard.getTaksitSayisi() > 9) {
            faizOrani = 0.7;
        }

        double faizliPara = creditCard.getAnaPara() + (creditCard.getAnaPara() * faizOrani);

        final int CARD_NUMBER_LENGTH = 16;
        Random random = new Random();
        StringBuilder cardNumberBuilder = new StringBuilder();


        for (int i = 0; i < CARD_NUMBER_LENGTH; i++) {
            cardNumberBuilder.append(random.nextInt(10)); // 0-9 arası rastgele rakam
        }

        final int CVV_LENGTH = 3;
        StringBuilder cvvBuilder = new StringBuilder();

        for (int i = 0; i < CVV_LENGTH; i++) {
            cvvBuilder.append(random.nextInt(10)); // 0-9 arası rastgele rakam
        }

        int month = random.nextInt(12) + 1;
        int year = random.nextInt(7) + 24;


        creditCard.setFaizliPara(faizliPara);
        creditCard.setCreditCardNumber(cardNumberBuilder.toString());
        creditCard.setCvv(cvvBuilder.toString());
        creditCard.setExpirationDate(month + "/" + year);

        return creditCardRepository.save(creditCard).getId();
    }
}
