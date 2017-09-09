package com.tenkaten.coindash.controllers;

import com.tenkaten.coindash.services.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    private final DashboardService dashboardService;

    @Autowired
    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping({"/", "/dashboard"})
    public String getDashboard(Model model) {
        model.addAttribute("cryptoCoins", dashboardService.getCryptoCoins());
        return "dashboard";
    }
}
