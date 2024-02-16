package com.corebank.corebank.converters;

import com.corebank.corebank.enums.AccountType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;
@Converter
public class AccountTypeConverter implements AttributeConverter<AccountType, String> {
    @Override
    public String convertToDatabaseColumn(AccountType attribute) {
        return  attribute.getName();
    }

    @Override
    public AccountType convertToEntityAttribute(String dbData) {
        return Stream.of(AccountType.values())
                .filter(accountTypeName -> accountTypeName.getName().equals(dbData))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
