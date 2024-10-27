package com.eta.ExpenseTrackerApp.security;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AuthRequest {
    private String username;
    private String password;

    // Getters and Setters
}