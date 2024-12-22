package com.spring.demo.portfoliobackend.controller;

import com.spring.demo.portfoliobackend.entity.Stock;
import com.spring.demo.portfoliobackend.services.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/portfolio")
public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;

    @GetMapping("/total-value")
    public double getTotalPortfolioValue() {
        return portfolioService.getTotalPortfolioValue();
    }

    @GetMapping("/top-performing")
    public Stock getTopPerformingStock() {
        return portfolioService.getTopPerformingStock();
    }

    @GetMapping("/distribution")
    public Map<String, Double> getPortfolioDistribution() {
        return portfolioService.getPortfolioDistribution();
    }
}