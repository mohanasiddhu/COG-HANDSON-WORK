package com.cognizant.loanservice.dto;

import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoanResponseDTO {
    private Long id;
    private String loanNumber;
    private String loanType;
    private Double loanAmount;
    private Double outstandingBalance;
    private Long accountId;
    private String status;
    private LocalDateTime createdAt;
}
