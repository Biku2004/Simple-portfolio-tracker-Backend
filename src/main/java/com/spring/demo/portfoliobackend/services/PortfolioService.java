package com.spring.demo.portfoliobackend.services;

import com.spring.demo.portfoliobackend.entity.Stock;
import com.spring.demo.portfoliobackend.metrices.PortfolioMetrics;
import com.spring.demo.portfoliobackend.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PortfolioService {

    @Autowired
    private StockRepository stockRepository;

    public double getTotalPortfolioValue() {
        List<Stock> stocks = stockRepository.findAll();
        return PortfolioMetrics.calculateTotalPortfolioValue(stocks);
    }

    public Stock getTopPerformingStock() {
        List<Stock> stocks = stockRepository.findAll();
        return PortfolioMetrics.findTopPerformingStock(stocks);
    }

    public Map<String, Double> getPortfolioDistribution() {
        List<Stock> stocks = stockRepository.findAll();
        return PortfolioMetrics.calculatePortfolioDistribution(stocks);
    }
}