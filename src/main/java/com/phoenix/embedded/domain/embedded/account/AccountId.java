package com.phoenix.embedded.domain.embedded.account;

import java.io.Serializable;
import java.util.Objects;

public class AccountId implements Serializable {
    private String accountNumber;
    private String accountType;

    public AccountId(){};

    public AccountId(String accountNumber, String accountType){
        this.accountNumber = accountNumber;
        this.accountType = accountType;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AccountId accountId)) return false;
        return Objects.equals(getAccountNumber(), accountId.getAccountNumber()) && Objects.equals(getAccountType(), accountId.getAccountType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAccountNumber(), getAccountType());
    }
}
