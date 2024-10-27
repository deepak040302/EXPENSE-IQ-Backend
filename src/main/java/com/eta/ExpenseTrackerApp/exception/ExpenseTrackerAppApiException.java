package com.eta.ExpenseTrackerApp.exception;


public class ExpenseTrackerAppApiException extends RuntimeException {
    private final String message;

    public ExpenseTrackerAppApiException(String message) {
        super(message);
        this.message = message;
    }

}
