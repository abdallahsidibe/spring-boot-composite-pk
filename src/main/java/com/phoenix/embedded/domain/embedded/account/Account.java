package com.phoenix.embedded.domain.embedded.account;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

@Entity
@IdClass(AccountId.class)
public class Account {
    @Id
    private String accountNumber;

    @Id
    private String accountType;
}
