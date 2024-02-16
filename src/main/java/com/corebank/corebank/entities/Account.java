package com.corebank.corebank.entities;

import com.corebank.corebank.converters.AccountTypeConverter;
import com.corebank.corebank.enums.AccountType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "accounts")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Account extends BaseEntity{
    //id, number,type, balance
    //one_client, many_transaction
    @Column(unique = true, nullable = false)
    private String number;


    //@ManyToOne
    @Convert(converter = AccountTypeConverter.class)
    @JoinColumn(name="type_id", nullable = false)
    private AccountType type;

    @Column(nullable = false)
    private double balance=0;

    @OneToMany(mappedBy = "account")
    private List<Transaction> transactions;

    @ManyToOne
    @JoinColumn(name="client_id")
    @JsonIgnore
    private Client client;


}
