package com.corebank.corebank.entities.projections;

import com.corebank.corebank.entities.Account;
import com.corebank.corebank.enums.AccountType;
import com.corebank.corebank.entities.Client;
import com.corebank.corebank.entities.Transaction;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.time.LocalDateTime;
import java.util.List;

public interface AccountDto {
    Long getId();

    String getNumber();
    AccountType getType();

    double getBalance();

    Account getAccount();

    List<Transaction> getTransactions();

    Client getOwner();



}
