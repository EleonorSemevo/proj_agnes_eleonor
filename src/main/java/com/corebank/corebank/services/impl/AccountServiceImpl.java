

package com.corebank.corebank.services.impl;

import com.corebank.corebank.dtos.CreateAccountDto;
import com.corebank.corebank.entities.projections.AccountDto;
import com.corebank.corebank.repositories.AccountRepository;
import com.corebank.corebank.repositories.ClientRepository;
import com.corebank.corebank.repositories.TransactionRepository;
import com.corebank.corebank.services.AccountService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class AccountServiceImpl implements AccountService {
    private final ClientRepository clientRepository;
    private  final AccountRepository accountRepository;
    private  final TransactionRepository transactionRepository;

    static String letters="abcdefghijklmnoprstuvwxyz";



    public AccountServiceImpl(ClientRepository clientRepository,
                             AccountRepository accountRepository,
                              TransactionRepository transactionRepository
    ) {
        this.clientRepository = clientRepository;
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }


    @Override
    public void createAccount(CreateAccountDto dto) {
         /* Optional<AccountType> accountType = accountTypeRepository.findAccountTypeByName(dto.getAccount_type());

        if(accountType.isEmpty()){
            throw new CustomEntityNotFoundException("account_type");
        }
        System.out.println(accountType);
        System.out.println("************** "+ dto.getAccount_type());



        Client client = Client.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .createdAt(LocalDateTime.now())
                .build();

        clientRepository.save(client);*/
    }

    @Override
    public Page<AccountDto> getAccounts(Pageable pageable, String start, String end) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm");

        LocalDateTime startDate= LocalDateTime.parse(start, formatter);
                //DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        LocalDateTime endDate = LocalDateTime.parse(end, formatter);
        return accountRepository.findByCreatedAtAfterAndCreatedAtBefore(startDate, endDate,pageable);
    }


}
