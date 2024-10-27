package com.eta.ExpenseTrackerApp.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "EXPENSE_ExpenseIQ")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String subject;
    private String merchant;
    private LocalDate createdDate;
    private Double total;
    private String category;
    private String description;
    private String username;
    @Lob
    private String document;
    // Getters and Setter

    public Expense(long id, String subject, String merchant, LocalDate createdDate, double total, String category, String description,String username) {
        this.id = id;
        this.subject = subject;
        this.merchant = merchant;
        this.createdDate = createdDate;
        this.total = total;
        this.category = category;
        this.description = description;
        this.username = username;
    }

    public Expense(long id, String subject, String merchant, LocalDate createdDate, double total, String category, String description) {
        this.id = id;
        this.subject = subject;
        this.merchant = merchant;
        this.createdDate = createdDate;
        this.total = total;
        this.category = category;
        this.description = description;
    }


    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", merchant='" + merchant + '\'' +
                ", createdDate=" + createdDate +
                ", total=" + total +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
