package com.eta.ExpenseTrackerApp.controllers;

import com.eta.ExpenseTrackerApp.models.Expense;
import com.eta.ExpenseTrackerApp.models.Income;
import com.eta.ExpenseTrackerApp.service.ExpenseService;
import com.eta.ExpenseTrackerApp.service.IncomeService;
import com.eta.ExpenseTrackerApp.utils.CurrentLoggedInUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TransactionsController {

    @Autowired
    private IncomeService incomeService;

    @Autowired
    private ExpenseService expenseService;

    // Income Endpoints
    @PostMapping("/add-income")
    public ResponseEntity<Income> addIncome(@RequestBody Income income) {
        income.setUsername(CurrentLoggedInUser.getCurrentLoggedInUsername());
        Income savedIncome = incomeService.addIncome(income);
        return ResponseEntity.ok(savedIncome);
    }

    @GetMapping("/get-incomes")
    public ResponseEntity<List<Income>> getIncomes() {
        List<Income> incomes = incomeService.getIncomes();
        return ResponseEntity.ok(incomes);
    }

    @DeleteMapping("/delete-income/{id}")
    public ResponseEntity<Void> deleteIncome(@PathVariable Long id) {
        incomeService.deleteIncome(id);
        return ResponseEntity.noContent().build();
    }

    // Expense Endpoints
    @PostMapping("/add-expense")
    public ResponseEntity<Expense> addExpense(@RequestBody Expense expense) {
        expense.setUsername(CurrentLoggedInUser.getCurrentLoggedInUsername());
        Expense savedExpense = expenseService.addExpense(expense);
        return ResponseEntity.ok(savedExpense);
    }

    @GetMapping("/get-expenses")
    public ResponseEntity<List<Expense>> getExpenses() {
        List<Expense> expenses = expenseService.getExpenses();
        return ResponseEntity.ok(expenses);
    }

    @DeleteMapping("/delete-expense/{id}")
    public ResponseEntity<Void> deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
        return ResponseEntity.noContent().build();
    }


}
