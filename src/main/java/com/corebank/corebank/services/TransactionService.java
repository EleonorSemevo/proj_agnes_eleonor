

package com.corebank.corebank.services;
        import com.corebank.corebank.dtos.CreateAccountDto;
        import com.corebank.corebank.dtos.CreateTransactionDto;
        import com.corebank.corebank.dtos.RegisterClientDto;
        import com.corebank.corebank.entities.projections.AccountDto;
        import com.corebank.corebank.entities.projections.TransactionDto;
        import org.springframework.data.domain.Page;
        import org.springframework.data.domain.Pageable;


public interface TransactionService {
    void createTransaction(CreateTransactionDto dto, Long account_id);
    Page<TransactionDto> findTransactions(Pageable pageable, String start, String end);
}


