package com.eta.ExpenseTrackerApp.dao;

import com.eta.ExpenseTrackerApp.models.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Long> {
    @Query("SELECT new com.eta.ExpenseTrackerApp.models.Income(e.id, e.subject, e.merchant, e.createdDate, e.total, e.category, e.description, e.username) " +
            "FROM Income e WHERE e.username = :username")
    List<Income> findIncomesExcludingDocument(@Param("username") String username);

}
