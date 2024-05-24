package org.example.atmdataproject.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Data
@Table(name = "app_user")
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class User {
    @Id
    @Column(length = 4)
    @GeneratedValue
    private Integer id;

    @Column(length = 15)
    private String name;

    @Column(length = 15)
    private String surname;

    @Column(nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime createTime;

    @Column(insertable = false)
    @LastModifiedDate
    private LocalDateTime lastModified;

    @Column(length = 4)
    private boolean isActive;//boolean

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
}


