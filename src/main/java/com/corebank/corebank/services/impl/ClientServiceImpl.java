package com.corebank.corebank.services.impl;
import com.corebank.corebank.enums.AccountType;

import com.corebank.corebank.dtos.AssignAccountDto;
import com.corebank.corebank.dtos.RegisterClientDto;
import com.corebank.corebank.entities.Account;
import com.corebank.corebank.entities.Client;
import com.corebank.corebank.exceptions.CustomEntityNotFoundException;
import com.corebank.corebank.repositories.AccountRepository;
//import com.corebank.corebank.repositories.AccountTypeRepository;
import com.corebank.corebank.repositories.ClientRepository;
import com.corebank.corebank.services.ClientService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    private  final AccountRepository accountRepository;



    public ClientServiceImpl(ClientRepository clientRepository,
                             AccountRepository accountRepository
                             ) {
        this.clientRepository = clientRepository;
        //this.accountTypeRepository = accountTypeRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public void registerClient(RegisterClientDto dto) {
        //nouveau client + nouveau compte;

        Client client = Client.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .createdAt(LocalDateTime.now())
                .build();

        clientRepository.save(client);


        AccountType accountType = null;
        for(int i=0;i<AccountType.values().length;i++){
            if(AccountType.values()[i].getName().equals(dto.getAccount_type())){
                 accountType = AccountType.values()[i];

                break;
            }
        }
        if(accountType==null){
            throw new CustomEntityNotFoundException("account_type");
        }


        Account account =  Account.builder()
                        .type(accountType)
                        .owner(client)
                        .number(generateAccountNumber())
                        .balance(0)
                        .createdAt(LocalDateTime.now())
                        .build();

        accountRepository.save(account);



    }

    @Override
    public void addNewAccountToClient(AssignAccountDto dto, Long clientId) {

        AccountType accountType = null;
        for(int i=0;i<AccountType.values().length;i++){
            if(AccountType.values()[i].getName().equals(dto.getAccount_type())){
                accountType = AccountType.values()[i];

                break;
            }
        }
        if(accountType==null){
            throw new CustomEntityNotFoundException("account_type");
        }
        System.out.println("CLIENT ID ### "+clientId);
        Optional<Client> client = clientRepository.findById(clientId);


        if(client.isEmpty()){
            throw new CustomEntityNotFoundException("client");
        }
        Account account =  Account.builder()
                .type(accountType)
                .number(generateAccountNumber())
                .balance(0)
                .createdAt(LocalDateTime.now())
                .owner(client.get()).build();

       // accountTypeRepository.save(account);
        accountRepository.save(account);


    }

     String generateAccountNumber(){
       //PRENDRE LA LISTE DES COMPTE
        //VERIFIER SI LE NUMERO EXISTE DEJA
         List<String> accounts = accountRepository.findNumber();


        String number = "";
        do{
            number="";
            for(int i=0;i<10;i++){
                number=number+ new Random().nextInt(0,10);
            }
        } while (accounts.contains(number));




        return  number;
    }

}
