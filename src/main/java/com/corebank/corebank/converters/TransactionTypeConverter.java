package com.corebank.corebank.converters;

import com.corebank.corebank.enums.TransactionType;
import com.corebank.corebank.enums.TransactionTypeName;
import jakarta.persistence.AttributeConverter;

import java.util.stream.Stream;

public class TransactionTypeConverter implements AttributeConverter<TransactionType, String> {

    @Override
    public String convertToDatabaseColumn(TransactionType attribute) {
        return attribute.getName();
    }

    @Override
    public TransactionType convertToEntityAttribute(String dbData) {
        return Stream.of(TransactionType.values())
                .filter(transactionTypeName -> transactionTypeName.getName().equals(dbData))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
