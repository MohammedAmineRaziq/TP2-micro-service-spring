package com.sid.bankaccountserver;

import com.sid.bankaccountserver.entities.BankAccount;
import com.sid.bankaccountserver.enums.AccountType;
import com.sid.bankaccountserver.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class BankAccountServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAccountServerApplication.class, args);
	}

	@Bean
	CommandLineRunner start(BankAccountRepository bankAccountRepository){
		return args -> {
			for (int i = 0; i < 10; i++) {
				BankAccount bankAccount = BankAccount.builder()
						.id(UUID.randomUUID().toString())
						.balance(1000+Math.random()*10000)
						.creationDate(new Date())
						.currency("MAD")
						.type(Math.random() < 0.5 ? AccountType.SAVINGS_ACCOUNT : AccountType.CURRENT_ACCOUNT)
						.build();
				bankAccountRepository.save(bankAccount);
			}
		};
	}
}
