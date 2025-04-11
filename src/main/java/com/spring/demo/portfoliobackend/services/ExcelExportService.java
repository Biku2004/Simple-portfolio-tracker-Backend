package com.spring.demo.portfoliobackend.services;

import com.spring.demo.portfoliobackend.entity.Stock;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ExcelExportService {

    public ByteArrayInputStream exportStocksToExcel(List<Stock> stocks) throws IOException {
        // Create a new workbook
        try (Workbook workbook = new XSSFWorkbook()) {
            // Create a sheet
            Sheet sheet = workbook.createSheet("Stocks");

            // Create header row
            Row headerRow = sheet.createRow(0);
            String[] columns = {
                    "Stock Name", "Ticker", "Quantity", "Buy Price", "Current Price",
                    "Total Value", "Profit/Loss", "Profit/Loss (%)"
            };

            // Style for header
            CellStyle headerStyle = workbook.createCellStyle();
            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerFont.setFontHeightInPoints((short) 12);
            headerStyle.setFont(headerFont);
            headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            // Create header cells
            for (int i = 0; i < columns.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columns[i]);
                cell.setCellStyle(headerStyle);
            }

            // Create data rows
            CellStyle dataStyle = workbook.createCellStyle();
            dataStyle.setBorderBottom(BorderStyle.THIN);
            dataStyle.setBorderTop(BorderStyle.THIN);
            dataStyle.setBorderLeft(BorderStyle.THIN);
            dataStyle.setBorderRight(BorderStyle.THIN);

            int rowNum = 1;
            for (Stock stock : stocks) {
                Row row = sheet.createRow(rowNum++);

                row.createCell(0).setCellValue(stock.getName());
                row.createCell(1).setCellValue(stock.getTicker());
                row.createCell(2).setCellValue(stock.getQuantity());
                row.createCell(3).setCellValue(stock.getBuyPrice());
                row.createCell(4).setCellValue(stock.getCurrentPrice());
                row.createCell(5).setCellValue(stock.getTotalValue());
                row.createCell(6).setCellValue(stock.getProfitLoss());
                row.createCell(7).setCellValue(stock.getProfitLossPercentage());

                // Apply data style to each cell
                for (int i = 0; i < columns.length; i++) {
                    row.getCell(i).setCellStyle(dataStyle);
                }
            }

            // Auto-size columns
            for (int i = 0; i < columns.length; i++) {
                sheet.autoSizeColumn(i);
            }

            // Write to output stream
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }
}