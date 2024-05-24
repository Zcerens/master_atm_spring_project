package org.example.atmdataproject.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.atmdataproject.validation.ValidBankAccountCreate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Data
@Table(name = "app_bank_accounts")
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@ValidBankAccountCreate
public class BankAccount {
    @Id
    @Column(length = 3)
    @GeneratedValue
    private Integer accountId;
    private Integer balance;
    private Integer islemYapilanParaTutari;


    @ManyToOne // Many banka hesabı bir kişiye ait olabilir
    @JoinColumn(name = "user_id") // İlişkiyi sağlayan sütunun adı
    private User user; // Bankanın bağlı olduğu user

    @Column(nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime createTime;

    @Column(insertable = false)
    @LastModifiedDate
    private LocalDateTime lastModified;
}

