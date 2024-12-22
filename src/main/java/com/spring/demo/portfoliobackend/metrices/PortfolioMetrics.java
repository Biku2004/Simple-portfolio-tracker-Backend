package com.spring.demo.portfoliobackend.metrices;

import com.spring.demo.portfoliobackend.entity.Stock;

public class PortfolioMetrics {
    private double totalValue;
    private Stock topStock;

    public PortfolioMetrics(double totalValue, Stock topStock) {
        this.totalValue = totalValue;
        this.topStock = topStock;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    public Stock getTopStock() {
        return topStock;
    }

    public void setTopStock(Stock topStock) {
        this.topStock = topStock;
    }


}