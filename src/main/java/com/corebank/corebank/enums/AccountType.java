package com.corebank.corebank.enums;
import com.corebank.corebank.converters.AccountTypeConverter;

import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
@AllArgsConstructor @Getter

public enum AccountType {
    CURRENT("CURRENT", 0), SAVING("SAVING", 2500);

    @Convert(converter = AccountTypeConverter.class)
    private String name;
    private int minBalance;
}