package com.spring.demo.portfoliobackend.repository;

import com.spring.demo.portfoliobackend.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
}