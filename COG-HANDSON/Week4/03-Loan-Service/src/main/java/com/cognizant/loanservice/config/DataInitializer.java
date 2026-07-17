package com.cognizant.loanservice.config;

import com.cognizant.loanservice.entity.Loan;
import com.cognizant.loanservice.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    private final LoanRepository repository;

    @Override
    public void run(String... args) throws Exception {
        if (repository.count() == 0) {
            repository.save(Loan.builder()
                    .loanNumber("LN50001")
                    .loanType("HOME")
                    .loanAmount(250000.0)
                    .outstandingBalance(250000.0)
                    .accountId(1L)
                    .status("APPROVED")
                    .createdAt(LocalDateTime.now())
                    .build());

            repository.save(Loan.builder()
                    .loanNumber("LN50002")
                    .loanType("CAR")
                    .loanAmount(45000.0)
                    .outstandingBalance(45000.0)
                    .accountId(1L)
                    .status("PENDING")
                    .createdAt(LocalDateTime.now())
                    .build());
        }
    }
}
