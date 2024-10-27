package com.eta.ExpenseTrackerApp.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "user_data")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String fullName;
    private String email;
    private String username;
    private String password;
    private String country;
    private String currencySymbol;
    // Getters and setters
}
