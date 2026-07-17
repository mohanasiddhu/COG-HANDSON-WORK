package com.cognizant.accountservice.service;

import com.cognizant.accountservice.dto.AccountRequestDTO;
import com.cognizant.accountservice.dto.AccountResponseDTO;
import com.cognizant.accountservice.entity.Account;
import com.cognizant.accountservice.exception.InsufficientBalanceException;
import com.cognizant.accountservice.exception.ResourceNotFoundException;
import com.cognizant.accountservice.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository repository;

    private AccountResponseDTO mapToDTO(Account account) {
        return AccountResponseDTO.builder()
                .id(account.getId())
                .accountNumber(account.getAccountNumber())
                .accountHolderName(account.getAccountHolderName())
                .accountType(account.getAccountType())
                .balance(account.getBalance())
                .createdAt(account.getCreatedAt())
                .build();
    }

    @Override
    public AccountResponseDTO createAccount(AccountRequestDTO dto) {
        Account account = Account.builder()
                .accountNumber(dto.getAccountNumber())
                .accountHolderName(dto.getAccountHolderName())
                .accountType(dto.getAccountType())
                .balance(dto.getBalance())
                .createdAt(LocalDateTime.now())
                .build();
        return mapToDTO(repository.save(account));
    }

    @Override
    public List<AccountResponseDTO> getAllAccounts() {
        return repository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public AccountResponseDTO getAccountById(Long id) {
        Account account = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with ID: " + id));
        return mapToDTO(account);
    }

    @Override
    public AccountResponseDTO updateAccount(Long id, AccountRequestDTO dto) {
        Account account = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with ID: " + id));
        account.setAccountHolderName(dto.getAccountHolderName());
        account.setAccountType(dto.getAccountType());
        account.setAccountNumber(dto.getAccountNumber());
        return mapToDTO(repository.save(account));
    }

    @Override
    public void deleteAccount(Long id) {
        Account account = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with ID: " + id));
        repository.delete(account);
    }

    @Override
    public AccountResponseDTO deposit(Long id, Double amount) {
        Account account = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with ID: " + id));
        account.setBalance(account.getBalance() + amount);
        return mapToDTO(repository.save(account));
    }

    @Override
    public AccountResponseDTO withdraw(Long id, Double amount) {
        Account account = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with ID: " + id));
        if (account.getBalance() < amount) {
            throw new InsufficientBalanceException("Withdrawal failed: Insufficient balance. Remaining: " + account.getBalance());
        }
        account.setBalance(account.getBalance() - amount);
        return mapToDTO(repository.save(account));
    }
}
