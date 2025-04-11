package com.spring.demo.portfoliobackend.controller;

import com.spring.demo.portfoliobackend.entity.Stock;
import com.spring.demo.portfoliobackend.services.crudService;
import com.spring.demo.portfoliobackend.services.ExcelExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.util.List;

@CrossOrigin(origins = {"https://simple-portfolio-tracker-capx.netlify.app","https://simple-portfolio-tracker.site","http://localhost:4200"})
@RestController
@RequestMapping("/api/stocks")
public class crudController {
    @Autowired
    private crudService crudService;

    @Autowired
    private ExcelExportService excelExportService;

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

    @GetMapping("/")
    public void welcome() {
        System.out.println("Welcome to the Portfolio Backend");
    }

    // New endpoint for Excel export
    @GetMapping("/export/excel")
    public ResponseEntity<Resource> exportStocksToExcel() {
        try {
            List<Stock> stocks = crudService.getAllStocks();
            ByteArrayInputStream in = excelExportService.exportStocksToExcel(stocks);

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "attachment; filename=Stock_Portfolio_" + System.currentTimeMillis() + ".xlsx");

            return ResponseEntity.ok()
                    .headers(headers)
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(new InputStreamResource(in));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }
}