package com.cognizant.loanservice.controller;

import com.cognizant.loanservice.dto.LoanRequestDTO;
import com.cognizant.loanservice.dto.LoanResponseDTO;
import com.cognizant.loanservice.service.LoanService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/loans")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class LoanController {
    private final LoanService service;

    @PostMapping
    public ResponseEntity<LoanResponseDTO> applyForLoan(@Valid @RequestBody LoanRequestDTO dto) {
        return new ResponseEntity<>(service.applyForLoan(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<LoanResponseDTO>> getAllLoans() {
        return ResponseEntity.ok(service.getAllLoans());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoanResponseDTO> getLoanById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getLoanById(id));
    }

    @GetMapping("/account/{accountId}")
    public ResponseEntity<List<LoanResponseDTO>> getLoansByAccountId(@PathVariable Long accountId) {
        return ResponseEntity.ok(service.getLoansByAccountId(accountId));
    }

    @PutMapping("/{id}/approve")
    public ResponseEntity<LoanResponseDTO> approveLoan(@PathVariable Long id) {
        return ResponseEntity.ok(service.approveLoan(id));
    }

    @PutMapping("/{id}/reject")
    public ResponseEntity<LoanResponseDTO> rejectLoan(@PathVariable Long id) {
        return ResponseEntity.ok(service.rejectLoan(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLoan(@PathVariable Long id) {
        service.deleteLoan(id);
        return ResponseEntity.noContent().build();
    }
}
