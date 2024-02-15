package com.corebank.corebank.enums;

import com.corebank.corebank.converters.TransactionTypeConverter;
import jakarta.persistence.Convert;
import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public enum TransactionType {
    Deposits("Deposits", "in"),
    Transfer("Transfer", "out"),
    BillPayments("BillPayments", "out"),
    Charge("Charge", "in"),
    ATM("ATM", "out");

    @Convert(converter = TransactionTypeConverter.class)
    private String name;

    private String direction;
}