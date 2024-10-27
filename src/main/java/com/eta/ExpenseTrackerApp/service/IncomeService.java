package com.eta.ExpenseTrackerApp.service;

import com.eta.ExpenseTrackerApp.repository.IncomeRepository;
import com.eta.ExpenseTrackerApp.exception.ExpenseTrackerAppApiException;
import com.eta.ExpenseTrackerApp.entity.Income;
import com.eta.ExpenseTrackerApp.utils.CurrentLoggedInUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IncomeService {

    @Autowired
    private IncomeRepository incomeRepository;

    // Add an income
    public Income addIncome(Income income) {
        validateIncome(income);
        return incomeRepository.save(income);
    }

    // Get all incomes
    public List<Income> getIncomes() {
        return incomeRepository.findIncomesExcludingDocument(CurrentLoggedInUser.getCurrentLoggedInUsername());
    }

    // Delete an income by ID
    public void deleteIncome(Long id) {
        Optional<Income> income = incomeRepository.findById(id);
        if (income.isPresent()) {
            incomeRepository.deleteById(id);
        } else {
            throw new ExpenseTrackerAppApiException("Income not found with id " + id);
        }
    }

    private void validateIncome(Income income) {
        if (income == null) {
            throw new ExpenseTrackerAppApiException("Income cannot be null");
        }
        if (income.getMerchant() == null || income.getMerchant().isEmpty()) {
            throw new ExpenseTrackerAppApiException("Income merchant cannot be empty");
        }
        if (income.getSubject() == null || income.getSubject().isEmpty()) {
            throw new ExpenseTrackerAppApiException("Income subject cannot be empty");
        }
        if (income.getTotal() == null || income.getTotal() <= 0) {
            throw new ExpenseTrackerAppApiException("Income amount must be greater than zero");
        }
        if (income.getCreatedDate() == null) {
            throw new ExpenseTrackerAppApiException("Income date cannot be null is the");
        }
        if (income.getCategory() == null || income.getCategory().isEmpty()) {
            throw new ExpenseTrackerAppApiException("Income category cannot be empty");
        }
        if (income.getDescription() == null || income.getDescription().isEmpty()) {
            throw new ExpenseTrackerAppApiException("Income description cannot be empty");
        }
    }
}
