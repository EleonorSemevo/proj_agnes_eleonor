package com.corebank.corebank.services.impl;

        import com.corebank.corebank.dtos.CreateTransactionDto;
        import com.corebank.corebank.entities.*;
        import com.corebank.corebank.entities.projections.TransactionDto;
        import com.corebank.corebank.enums.TransactionType;
        import com.corebank.corebank.exceptions.CustomEntityNotFoundException;
        import com.corebank.corebank.repositories.*;
        import com.corebank.corebank.services.TransactionService;
        import org.springframework.data.domain.Page;
        import org.springframework.data.domain.Pageable;
        import org.springframework.stereotype.Service;

        import java.time.LocalDateTime;
        import java.time.format.DateTimeFormatter;
        import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {
    private final ClientRepository clientRepository;
    private  final AccountRepository accountRepository;
    private  final TransactionRepository transactionRepository;


    static String letters="abcdefghijklmnoprstuvwxyz";



    public TransactionServiceImpl(ClientRepository clientRepository,
                              AccountRepository accountRepository,
                              TransactionRepository transactionRepository

    ) {
        this.clientRepository = clientRepository;
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
       // this.transactionTypeRepository = transactionTypeRepository;
    }


    //3### EFFECTUER UNE TRANSACTION
    @Override
    public void createTransaction(CreateTransactionDto dto,Long account_id) {
        //Optional<TransactionType> transactionType = transactionTypeRepository.findTransactionTypeByName(dto.getTransaction_type());

        TransactionType transactionType = null;
        for(int i=0;i<TransactionType.values().length;i++){
            if(TransactionType.values()[i].getName().equals(dto.getTransaction_type())){
                transactionType = TransactionType.values()[i];

                break;
            }
        }
        if(transactionType==null){
            throw new CustomEntityNotFoundException("transaction_type");
        }

        Optional<Account> account = accountRepository.findById(account_id);

        if(account.isEmpty()){
            throw new CustomEntityNotFoundException("account");
        }
        if(transactionType.getDirection().equals("out") &&  account.get().getType().getMinBalance()>(account.get().getBalance()-dto.getAmount())){
            throw new CustomEntityNotFoundException("Montant insuffisant ");

        }



        Transaction transaction = Transaction.builder()
                        .account(account.get())
                .amount(dto.getAmount())
                .date(LocalDateTime.now())
                        .type(transactionType).build();





        transactionRepository.save(transaction);
    }

    @Override
    public Page<TransactionDto> findTransactions(Long account_id,Pageable pageable, String start, String end) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm");

        LocalDateTime startDate= LocalDateTime.parse(start, formatter);
        //DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        LocalDateTime endDate = LocalDateTime.parse(end, formatter);

        Optional<Account> account = accountRepository.findById(account_id);
        if(account.isEmpty()){
            throw new CustomEntityNotFoundException("acccount");
        }
        return transactionRepository.findByAccountAndDateAfterAndDateBeforeAndDateIsAndDateIs(account.get(), startDate, endDate,startDate, endDate,pageable);
    }
}


