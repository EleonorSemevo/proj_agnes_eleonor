package com.corebank.corebank.controllers;

import com.corebank.corebank.constraints.IsValidClientId;
import com.corebank.corebank.dtos.AssignAccountDto;
import com.corebank.corebank.dtos.RegisterClientDto;
import com.corebank.corebank.services.AccountService;
import com.corebank.corebank.services.ClientService;
import jakarta.validation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping(path = "/api/v1/clients")
public class ClientController {
    private final ClientService clientService;
    private final AccountService accountService;

    public ClientController(ClientService clientService, AccountService accountService) {
        this.clientService = clientService;
        this.accountService = accountService;
    }

    //POUR ENRÉGISTRER UN NOUVEAU CLIENT AVEC UN NOUVEAU COMPTE
    @PostMapping
    public ResponseEntity<String> registerClient(
            @Valid @RequestBody RegisterClientDto dto, BindingResult result
            ) {

        System.out.println("###"+result);
        clientService.registerClient(dto);
        if(result.getAllErrors().size()!=0){
            System.out.println("###ERROR");
            return new ResponseEntity<>(result.getAllErrors().toString(),HttpStatus.OK);
        }
        return new ResponseEntity<>(
                "Client registered successfully", HttpStatus.CREATED);
    }

    //OUVRIR UN COMPTE À UN CLIENT EXISTANT
    @PostMapping("/{client_id}")
    public ResponseEntity<String> addNewAccount(@Valid @RequestBody AssignAccountDto dto,
            @IsValidClientId  @PathVariable Long client_id){
        clientService.addNewAccountToClient(dto,client_id);
        return new ResponseEntity<>(
                "Client registered successfully", HttpStatus.CREATED);

    }





}
