package com.cognizant.loanservice.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoanRequestDTO {
    @NotBlank(message = "Loan number is required")
    private String loanNumber;

    @NotBlank(message = "Loan type is required")
    @Pattern(regexp = "^(HOME|PERSONAL|CAR)$", message = "Loan type must be HOME, PERSONAL or CAR")
    private String loanType;

    @NotNull(message = "Loan amount is required")
    @Min(value = 5000, message = "Minimum loan amount is 5000")
    private Double loanAmount;

    @NotNull(message = "Account ID is required")
    private Long accountId;
}
