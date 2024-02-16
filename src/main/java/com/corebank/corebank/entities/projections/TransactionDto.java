package com.corebank.corebank.entities.projections;

import com.corebank.corebank.enums.TransactionType;

import java.time.LocalDateTime;

public interface TransactionDto {
    double getId();
    double getAmount();

    TransactionType getType();

    LocalDateTime getCreatedAt();







}
