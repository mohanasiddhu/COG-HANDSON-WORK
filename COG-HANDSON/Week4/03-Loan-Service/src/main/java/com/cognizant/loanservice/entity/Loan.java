package com.cognizant.loanservice.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "loans")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String loanNumber;

    @Column(nullable = false)
    private String loanType; // HOME, PERSONAL, CAR

    @Column(nullable = false)
    private Double loanAmount;

    @Column(nullable = false)
    private Double outstandingBalance;

    @Column(nullable = false)
    private Long accountId;

    @Column(nullable = false)
    private String status; // PENDING, APPROVED, REJECTED

    @Column(nullable = false)
    private LocalDateTime createdAt;
}
