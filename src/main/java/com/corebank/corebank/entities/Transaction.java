package com.corebank.corebank.entities;

import com.corebank.corebank.converters.AccountTypeConverter;
import com.corebank.corebank.converters.TransactionTypeConverter;
import com.corebank.corebank.enums.TransactionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "transactions")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Transaction extends  BaseEntity{
    //id, amount,type, created_at
    //one_account

    @Column(unique = true, nullable = false)
    private double amount;


    @Convert(converter = TransactionTypeConverter.class)
    @JoinColumn(name="type_id", nullable = false)
    private TransactionType type;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
}
