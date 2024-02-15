package com.corebank.corebank.enums;

import lombok.AllArgsConstructor; import lombok.Getter;
@AllArgsConstructor
@Getter
public enum TransactionTypeName {
    Deposits("Deposits", "in"),
    Transfer("Transfer", "out"),
    BillPayments("BillPayments", "out"),
    Charge("Charge", "in"),
    ATM("ATM", "out");

    private String name;
    private String direction;
}
