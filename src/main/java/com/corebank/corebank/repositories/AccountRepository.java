package com.corebank.corebank.repositories;

import com.corebank.corebank.entities.Account;
import com.corebank.corebank.entities.projections.AccountDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    @Query("SELECT a FROM Account a")
    Page<AccountDto> findAccountsByCreatedDate(Pageable pageable);

    @Query("SELECT c FROM Account c")
    Page<AccountDto> findByCreatedAtAfterAndCreatedAtBefore(LocalDateTime date1, LocalDateTime date2, Pageable pageable);

    @Query("SELECT c.number FROM Account c")
    List<String> findNumber();
}
