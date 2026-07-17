package com.cognizant.loanservice.service;

import com.cognizant.loanservice.dto.LoanRequestDTO;
import com.cognizant.loanservice.dto.LoanResponseDTO;
import com.cognizant.loanservice.entity.Loan;
import com.cognizant.loanservice.exception.ResourceNotFoundException;
import com.cognizant.loanservice.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService {
    private final LoanRepository repository;

    private LoanResponseDTO mapToDTO(Loan loan) {
        return LoanResponseDTO.builder()
                .id(loan.getId())
                .loanNumber(loan.getLoanNumber())
                .loanType(loan.getLoanType())
                .loanAmount(loan.getLoanAmount())
                .outstandingBalance(loan.getOutstandingBalance())
                .accountId(loan.getAccountId())
                .status(loan.getStatus())
                .createdAt(loan.getCreatedAt())
                .build();
    }

    @Override
    public LoanResponseDTO applyForLoan(LoanRequestDTO dto) {
        Loan loan = Loan.builder()
                .loanNumber(dto.getLoanNumber())
                .loanType(dto.getLoanType())
                .loanAmount(dto.getLoanAmount())
                .outstandingBalance(dto.getLoanAmount())
                .accountId(dto.getAccountId())
                .status("PENDING")
                .createdAt(LocalDateTime.now())
                .build();
        return mapToDTO(repository.save(loan));
    }

    @Override
    public List<LoanResponseDTO> getAllLoans() {
        return repository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public LoanResponseDTO getLoanById(Long id) {
        Loan loan = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Loan not found with ID: " + id));
        return mapToDTO(loan);
    }

    @Override
    public List<LoanResponseDTO> getLoansByAccountId(Long accountId) {
        return repository.findByAccountId(accountId).stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public LoanResponseDTO approveLoan(Long id) {
        Loan loan = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Loan not found with ID: " + id));
        loan.setStatus("APPROVED");
        return mapToDTO(repository.save(loan));
    }

    @Override
    public LoanResponseDTO rejectLoan(Long id) {
        Loan loan = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Loan not found with ID: " + id));
        loan.setStatus("REJECTED");
        return mapToDTO(repository.save(loan));
    }

    @Override
    public void deleteLoan(Long id) {
        Loan loan = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Loan not found with ID: " + id));
        repository.delete(loan);
    }
}
