
package com.corebank.corebank.services;
import com.corebank.corebank.dtos.CreateAccountDto;
import com.corebank.corebank.dtos.RegisterClientDto;
import com.corebank.corebank.entities.projections.AccountDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface AccountService {
    void createAccount(CreateAccountDto dto);

    Page<AccountDto> getAccounts(Pageable pageable, String start, String end);
}

