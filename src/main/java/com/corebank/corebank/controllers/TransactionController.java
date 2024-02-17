
package com.corebank.corebank.controllers;

        import com.corebank.corebank.constraints.IsValidAccountId;
        import com.corebank.corebank.dtos.CreateTransactionDto;
        import com.corebank.corebank.dtos.RegisterClientDto;
        import com.corebank.corebank.entities.projections.AccountDto;
        import com.corebank.corebank.entities.projections.TransactionDto;
        import com.corebank.corebank.services.ClientService;
        import com.corebank.corebank.services.TransactionService;
        import jakarta.validation.Valid;
        import org.springframework.data.domain.Page;
        import org.springframework.data.domain.PageRequest;
        import org.springframework.data.domain.Pageable;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

        import java.time.LocalDateTime;


@RestController
@RequestMapping(path = "/api/v1/accounts")
public class TransactionController {
    //private final ClientService clientService;
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        //this.clientService = clientService;
        this.transactionService= transactionService;
    }

    @GetMapping("/{account_id}/transactions")
    public ResponseEntity<Page<TransactionDto>> getProjects(
            @RequestParam(defaultValue = "0") String page,
            @RequestParam(defaultValue = "10") String size,
            @RequestParam String start,
            @RequestParam String end,
            @IsValidAccountId
            @PathVariable Long account_id
    ) {
        Pageable pageable = PageRequest.of(
                Integer.parseInt(page),
                Integer.parseInt(size)
        );

        return new ResponseEntity<>(transactionService.findTransactions(account_id, pageable,start,end), HttpStatus.OK);
    }

    @PostMapping("/{account_id}/transactions")
    public ResponseEntity<String> createTransaction(
            @Valid @RequestBody CreateTransactionDto dto,
            @IsValidAccountId
            @PathVariable Long account_id
    ) {
        transactionService.createTransaction(dto, account_id);
        return new ResponseEntity<>(
                "Transaction created successfully", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public String getProject(
            @PathVariable Long id
    ) {
        return id+"";
    }

    ///api/v1/accounts/{account_id}/transactions?start={start}&end={end}
    //  &page={page}&size={size}



}
