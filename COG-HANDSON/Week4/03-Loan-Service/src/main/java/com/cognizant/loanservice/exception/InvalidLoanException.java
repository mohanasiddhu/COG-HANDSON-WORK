package com.cognizant.loanservice.exception;

public class InvalidLoanException extends RuntimeException {
    public InvalidLoanException(String msg) {
        super(msg);
    }
}
