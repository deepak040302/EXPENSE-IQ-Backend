package com.eta.ExpenseTrackerApp.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/")
    public ResponseEntity<String> home() {
        return ResponseEntity.ok("home");
    }
}
