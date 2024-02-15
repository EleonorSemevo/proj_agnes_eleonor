package com.corebank.corebank.services;

import com.corebank.corebank.dtos.AssignAccountDto;
import com.corebank.corebank.dtos.RegisterClientDto;


public interface ClientService {
    void registerClient(RegisterClientDto dto);

    void addNewAccountToClient(AssignAccountDto dto, Long clientId);
}
