package com.cognizant.accountservice.controller;

import com.cognizant.accountservice.dto.AccountRequestDTO;
import com.cognizant.accountservice.dto.AccountResponseDTO;
import com.cognizant.accountservice.dto.TransactionDTO;
import com.cognizant.accountservice.service.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AccountController {
    private final AccountService service;

    @PostMapping
    public ResponseEntity<AccountResponseDTO> createAccount(@Valid @RequestBody AccountRequestDTO dto) {
        return new ResponseEntity<>(service.createAccount(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AccountResponseDTO>> getAllAccounts() {
        return ResponseEntity.ok(service.getAllAccounts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountResponseDTO> getAccountById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getAccountById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountResponseDTO> updateAccount(@PathVariable Long id, @Valid @RequestBody AccountRequestDTO dto) {
        return ResponseEntity.ok(service.updateAccount(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long id) {
        service.deleteAccount(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/deposit")
    public ResponseEntity<AccountResponseDTO> deposit(@PathVariable Long id, @Valid @RequestBody TransactionDTO transaction) {
        return ResponseEntity.ok(service.deposit(id, transaction.getAmount()));
    }

    @PostMapping("/{id}/withdraw")
    public ResponseEntity<AccountResponseDTO> withdraw(@PathVariable Long id, @Valid @RequestBody TransactionDTO transaction) {
        return ResponseEntity.ok(service.withdraw(id, transaction.getAmount()));
    }
}
