package com.eta.ExpenseTrackerApp.controllers;

import com.eta.ExpenseTrackerApp.dao.ExpenseRepository;
import com.eta.ExpenseTrackerApp.dao.IncomeRepository;
import com.eta.ExpenseTrackerApp.models.Expense;
import com.eta.ExpenseTrackerApp.models.Income;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HandleDocumentsController {

    @Autowired
    private IncomeRepository incomeRepository;

    @Autowired
    private ExpenseRepository expenseRepository;

    @GetMapping("/income-doc/{incomeId}")
    public ResponseEntity<String> getIncomeDocument(@PathVariable Long incomeId) {
        // Fetch the income entry from the database by ID
        Income income = incomeRepository.findById(incomeId).orElse(null);

        if (income != null && income.getDocument() != null) {
            // Return the Base64-encoded document directly
            return ResponseEntity.ok(income.getDocument());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Document not found");
        }
    }


    @GetMapping("/expense-doc/{expenseId}")
    public ResponseEntity<String> getExpenseDocument(@PathVariable Long expenseId) {
        // Fetch the income entry from the database by ID
        Expense expense = expenseRepository.findById(expenseId).orElse(null);

        if (expense != null && expense.getDocument() != null) {
            // Return the Base64-encoded document directly
            return ResponseEntity.ok(expense.getDocument());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Document not found");
        }
    }
}
