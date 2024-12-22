package com.spring.demo.portfoliobackend.controller;

import com.spring.demo.portfoliobackend.entity.Stock;
import com.spring.demo.portfoliobackend.metrices.PortfolioMetrics;
import com.spring.demo.portfoliobackend.services.crudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
public class crudController {
    @Autowired
    private crudService crudService;

    @GetMapping
    public List<Stock> getAllStocks() {
        return crudService.getAllStocks();
    }

    @GetMapping("/{id}")
    public Stock getStockById(@PathVariable Long id) {
        return crudService.getStockById(id);
    }

    @PostMapping
    public Stock saveStock(@RequestBody Stock stock) {
        return crudService.saveStock(stock);
    }

    @PutMapping("/{id}")
    public Stock updateStock(@PathVariable Long id, @RequestBody Stock stock) {
        stock.setId(id);
        return crudService.updateStock(stock);
    }


    @DeleteMapping("/{id}")
    public void deleteStock(@PathVariable Long id) {
        crudService.deleteStock(id);
    }
}