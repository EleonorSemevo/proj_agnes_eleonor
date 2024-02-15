package com.corebank.corebank;

import com.corebank.corebank.entities.Account;
import com.corebank.corebank.entities.Client;
import com.corebank.corebank.enums.AccountType;
import com.corebank.corebank.repositories.AccountRepository;
import com.corebank.corebank.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class CorebankApplication {

	public static void main(String[] args) {
		SpringApplication.run(CorebankApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(
			AccountRepository accountRepository,
			ClientRepository clientRepository

	) {
		return args -> {

			Client client = Client.builder()
					.name("Loren")
					.email("loren@gmail.com").build();
			clientRepository.save(client);

			Account account= Account.builder()
					.type(AccountType.CURRENT)
					.owner(client)
					.number("1234567890")
					.createdAt(LocalDateTime.now())
					.balance(0).build();
			accountRepository.save(account);


			//AccountType accountType1 =  AccountType.CURRENT;



			//accountTypeRepository.save(accountType1);

			//AccountType accountType2 =  AccountType.SAVING;



			//accountTypeRepository.save(accountType2);

		};
	}

}
