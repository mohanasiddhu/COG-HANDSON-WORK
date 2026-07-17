package com.cognizant.loanservice.service;

import com.cognizant.loanservice.dto.LoanRequestDTO;
import com.cognizant.loanservice.dto.LoanResponseDTO;
import java.util.List;

public interface LoanService {
    LoanResponseDTO applyForLoan(LoanRequestDTO dto);
    List<LoanResponseDTO> getAllLoans();
    LoanResponseDTO getLoanById(Long id);
    List<LoanResponseDTO> getLoansByAccountId(Long accountId);
    LoanResponseDTO approveLoan(Long id);
    LoanResponseDTO rejectLoan(Long id);
    void deleteLoan(Long id);
}
