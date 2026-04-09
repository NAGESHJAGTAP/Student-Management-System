package com.example.studentapp.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/dashboard")
    public String adminDashboard(Model model) {
        model.addAttribute("title", "Admin Dashboard");
        return "admin-dashboard";
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/user/dashboard")
    public String userDashboard(Model model) {
        model.addAttribute("title", "User Dashboard");
        return "user-dashboard";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "redirect:/user/dashboard";
    }
}