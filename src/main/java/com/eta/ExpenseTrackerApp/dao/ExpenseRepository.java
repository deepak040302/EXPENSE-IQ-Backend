package com.eta.ExpenseTrackerApp.dao;

import com.eta.ExpenseTrackerApp.models.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    @Query("SELECT new com.eta.ExpenseTrackerApp.models.Expense(e.id, e.subject, e.merchant, e.createdDate, e.total, e.category, e.description, e.username) " +
            "FROM Expense e WHERE e.username = :username")
    List<Expense> findExpensesExcludingDocument(@Param("username") String username);

}
