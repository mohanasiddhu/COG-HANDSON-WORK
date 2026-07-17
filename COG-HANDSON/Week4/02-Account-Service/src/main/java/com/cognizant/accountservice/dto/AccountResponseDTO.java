package com.cognizant.accountservice.dto;

import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountResponseDTO {
    private Long id;
    private String accountNumber;
    private String accountHolderName;
    private String accountType;
    private Double balance;
    private LocalDateTime createdAt;
}
