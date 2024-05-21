package org.example.atmdataproject.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Data
@Table(name ="app_credit_card")
@Entity
@NoArgsConstructor
public class CreditCard {
    @Id
    @GeneratedValue
    private Integer id;

    private String creditCardNumber;
    private String cvv;
    private String expirationDate;
    private int taksitSayisi;
    @Column(name = "ana_para")
    private int anaPara;
    private double faizliPara;

    @ManyToOne // Many kredi kartı bir banka hesabına ait olabilir
    @JoinColumn(name = "bank_account_id") // İlişkiyi sağlayan sütunun adı
    private BankAccount bankAccount; // Kredi kartının bağlı olduğu banka hesabı

    @Column(nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime createTime;
    @Column(insertable = false)
    @LastModifiedDate
    private LocalDateTime lastModified;
}



