package com.eta.ExpenseTrackerApp.service;

import com.eta.ExpenseTrackerApp.dao.ExpenseRepository;
import com.eta.ExpenseTrackerApp.exception.ExpenseTrackerAppApiException;
import com.eta.ExpenseTrackerApp.models.Expense;
import com.eta.ExpenseTrackerApp.utils.CurrentLoggedInUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    // Add an expense
    public Expense addExpense(Expense expense) {
        validateExpense(expense);
        return expenseRepository.save(expense);
    }

    // Get all expenses
    public List<Expense> getExpenses() {
        return expenseRepository.findExpensesExcludingDocument(CurrentLoggedInUser.getCurrentLoggedInUsername());
    }

    // Delete an expense by ID
    public void deleteExpense(Long id) {
        Optional<Expense> expense = expenseRepository.findById(id);
        if (expense.isPresent()) {
            expenseRepository.deleteById(id);
        } else {
            throw new ExpenseTrackerAppApiException("Expense not found with id " + id);
        }
    }

    private void validateExpense(Expense expense) {
        if (expense == null) {
            throw new ExpenseTrackerAppApiException("Expense cannot be null");
        }
        if (expense.getMerchant() == null || expense.getMerchant().isEmpty()) {
            throw new ExpenseTrackerAppApiException("Expense Merchant cannot be empty");
        }
        if (expense.getTotal() == null || expense.getTotal() <= 0) {
            throw new ExpenseTrackerAppApiException("Expense amount must be a positive number");
        }
        if (expense.getSubject() == null || expense.getSubject().isEmpty()) {
            throw new ExpenseTrackerAppApiException("Expense subject cannot be empty");
        }
        if (expense.getCreatedDate() == null) {
            throw new ExpenseTrackerAppApiException("Expense date cannot be null");
        }
        if (expense.getCategory() == null || expense.getCategory().isEmpty()) {
            throw new ExpenseTrackerAppApiException("Expense category cannot be empty");
        }
        if (expense.getDescription() == null || expense.getDescription().isEmpty()) {
            throw new ExpenseTrackerAppApiException("Expense description cannot be empty");
        }
    }
}
