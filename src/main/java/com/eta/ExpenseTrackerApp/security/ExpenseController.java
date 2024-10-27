package com.eta.ExpenseTrackerApp.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExpenseController {

    @GetMapping("/check-expense")
    public String getExpense() {
        return "Authenticated: Here is the expense data.";
    }
}
