package com.corebank.corebank.entities;

import com.corebank.corebank.converters.AccountTypeConverter;
import com.corebank.corebank.converters.TransactionTypeConverter;
import com.corebank.corebank.enums.TransactionType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

//@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "transactions")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Transaction
       // extends BaseEntity
{
    //id, amount,type, created_at
    //one_account
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private double amount;


    @Convert(converter = TransactionTypeConverter.class)
    @JoinColumn(name="type_id", nullable = false)
    private TransactionType type;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @Column
    //@DateTimeFormat("yyyyyMMHHmm")

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonIgnore
    private LocalDateTime date;
}
