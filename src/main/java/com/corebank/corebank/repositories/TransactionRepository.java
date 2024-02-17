package com.corebank.corebank.repositories;

        import com.corebank.corebank.entities.Account;
        import com.corebank.corebank.entities.Transaction;
        import com.corebank.corebank.entities.projections.TransactionDto;
        import org.springframework.data.domain.Page;
        import org.springframework.data.domain.Pageable;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.data.jpa.repository.Query;

        import java.time.LocalDateTime;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
        @Query("SELECT t FROM Transaction t")
        Page<TransactionDto> findTransactions(Pageable pageable);

       // @Query("SELECT t FROM Transaction t WHERE t.createdAt>:date1 , ")
        Page<TransactionDto> findByAccountAndDateAfterAndDateBeforeAndDateIsAndDateIs(Account account, LocalDateTime date1, LocalDateTime date2, LocalDateTime date3, LocalDateTime date4, Pageable pageable);

}
