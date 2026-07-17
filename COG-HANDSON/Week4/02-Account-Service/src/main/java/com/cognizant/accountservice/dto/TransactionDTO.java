package com.cognizant.accountservice.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {
    @NotNull(message = "Transaction amount is required")
    @Min(value = 1, message = "Amount must be greater than zero")
    private Double amount;
}
