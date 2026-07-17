package com.cognizant.accountservice.config;

import com.cognizant.accountservice.entity.Account;
import com.cognizant.accountservice.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    private final AccountRepository repository;

    @Override
    public void run(String... args) throws Exception {
        if (repository.count() == 0) {
            repository.save(Account.builder()
                    .accountNumber("ACC10001")
                    .accountHolderName("John Doe")
                    .accountType("SAVINGS")
                    .balance(5000.0)
                    .createdAt(LocalDateTime.now())
                    .build());

            repository.save(Account.builder()
                    .accountNumber("ACC10002")
                    .accountHolderName("Alice Smith")
                    .accountType("CURRENT")
                    .balance(12000.0)
                    .createdAt(LocalDateTime.now())
                    .build());
        }
    }
}
