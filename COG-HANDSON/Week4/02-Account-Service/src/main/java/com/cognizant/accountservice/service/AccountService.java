package com.cognizant.accountservice.service;

import com.cognizant.accountservice.dto.AccountRequestDTO;
import com.cognizant.accountservice.dto.AccountResponseDTO;
import java.util.List;

public interface AccountService {
    AccountResponseDTO createAccount(AccountRequestDTO dto);
    List<AccountResponseDTO> getAllAccounts();
    AccountResponseDTO getAccountById(Long id);
    AccountResponseDTO updateAccount(Long id, AccountRequestDTO dto);
    void deleteAccount(Long id);
    AccountResponseDTO deposit(Long id, Double amount);
    AccountResponseDTO withdraw(Long id, Double amount);
}
