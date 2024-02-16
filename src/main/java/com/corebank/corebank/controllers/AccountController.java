package com.corebank.corebank.controllers;

import com.corebank.corebank.dtos.CreateAccountDto;
import com.corebank.corebank.dtos.RegisterClientDto;
import com.corebank.corebank.entities.Account;
import com.corebank.corebank.entities.projections.AccountDto;
import com.corebank.corebank.services.AccountService;
import com.corebank.corebank.services.ClientService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;



@RestController
@RequestMapping(path = "/api/v1/accounts")
public class AccountController {
    //private final ClientService clientService;
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        //this.clientService = clientService;
        this.accountService= accountService;
    }

    @PostMapping
    public ResponseEntity<String> registerClient(
            @Valid @RequestBody CreateAccountDto dto
    ) {
        accountService.createAccount(dto);
        return new ResponseEntity<>(
                "Account created successfully", HttpStatus.CREATED);
    }

    //@GetMapping("/accounts?start={start}&end={end}&page={page}&size={size}")

    //4###-RAPPORT DE COMPTE SUR UNE PÉRIODE
    @GetMapping
    public ResponseEntity<Page<AccountDto>> getRapportAccounts(
            @RequestParam(defaultValue = "0") String page,
            @RequestParam(defaultValue = "10") String size,
            @RequestParam String start,
            @RequestParam String end
    ) {
        Pageable pageable = PageRequest.of(
                Integer.parseInt(page),
                Integer.parseInt(size)
        );

        return new ResponseEntity<>(accountService.getAccounts(pageable, start, end), HttpStatus.OK);
    }



}
