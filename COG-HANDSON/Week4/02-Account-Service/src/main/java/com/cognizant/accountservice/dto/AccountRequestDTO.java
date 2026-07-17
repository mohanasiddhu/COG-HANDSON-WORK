package com.cognizant.accountservice.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountRequestDTO {
    @NotBlank(message = "Account number is required")
    @Size(min = 5, max = 20, message = "Account number must be between 5 and 20 characters")
    private String accountNumber;

    @NotBlank(message = "Account holder name is required")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String accountHolderName;

    @NotBlank(message = "Account type is required")
    @Pattern(regexp = "^(SAVINGS|CURRENT)$", message = "Account type must be SAVINGS or CURRENT")
    private String accountType;

    @NotNull(message = "Initial balance is required")
    @Min(value = 1000, message = "Initial balance must be at least 1000")
    private Double balance;
}
