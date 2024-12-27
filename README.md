# Simple Portfolio Tracker - Backend


## Overview

The backend is a RESTful API built using **Spring Boot** and **MySQL**. It provides endpoints for managing stock data, calculating portfolio metrics, fetching market data, and supporting the frontend's functionality.

## Prerequisites

1.  **Java Development Kit (JDK)** (version 11 or higher)
    
2.  **Maven** (version 3.6 or higher)
    
3.  **MySQL Server**
    

## Features

1.  **Stock Management**:
    
    *   CRUD operations for stock data.
        
    *   Secure and efficient API design.
        
2.  **Market Insights**:
    
    *   Fetch stock prices, market news, and daily statistics.
        
3.  **Portfolio Calculations**:
    
    *   Total portfolio value.
        
    *   Top-performing stock.
        
    *   Portfolio distribution.
        
4.  **Stock Suggestions**:
    
    *   Search and auto-complete functionality for stock symbols.
        
5.  **CORS Support**:
    
    *   Preconfigured for Angular (localhost:4200).
        

## Installation and Setup

1.  ```
    git clone https://github.com/Biku2004/Portfolio-backend.git
    cd Portfolio-backend
    ```
    
    
2.  ```
    spring.datasource.username=<your_db_username>
    spring.datasource.password=<your_db_password>
    ```
    
    Other properties are pre-configured:properties
    ```
    spring.application.name=Portfolio-Backend
    spring.datasource.driver-classname=com.mysql.cj.jdbc.Driver
    spring.datasource.url=jdbc:mysql://portfolio.c7cmgocowyi6.ap-south-1.rds.amazonaws.com:3306/portfolio_db
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=truespring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialectserver.port=8080
    ```

4.  ```
    mvn clean install 
    java -jar target/portfolio-backend.jar
    ```
    
5.  ```
    http://localhost:8080
    ```
    

## CRUD API Endpoints

### Portfolio Metrics

*   ```GET /api/portfolio/total-value``` - Get total portfolio value.
    
*   ```GET /api/portfolio/top-performing``` - Get the top-performing stock.
    
*   ```GET /api/portfolio/distribution``` - Get portfolio distribution.
    

### Stock Management

*   ```GET /api/stocks``` - Retrieve all stocks.
    
*   ```GET /api/stocks/{id}``` - Retrieve a stock by ID.
    
*   ```POST /api/stocks``` - Add a new stock.
    
*   ```PUT /api/stocks/{id}``` - Update a stock.
    
*   ```DELETE /api/stocks/{id}``` - Delete a stock.
    

### Stock Data

*   ```GET /api/stocks/{symbol}/price``` - Get stock price by symbol (includes daily changes).
    
*   ```GET /api/stocks/{symbol}/statistics``` - Get stock statistics (daily changes).
    
*   ```GET /api/stocks/{symbol}/market-status``` - Get market status for a stock.
    
*   ```GET /api/stocks/{symbol}/market-news``` - Get market news for a specific company.
    
*   ```GET /api/stocks/{symbol}/basic-financials``` - Get basic financial data for a company.
    
*   ```GET /api/stocks/suggestions/{symbol}``` - Get stock suggestions for a given keyword.
    

### Portfolio Insights

*   ```GET /api/stocks/metrics``` - Fetch portfolio-wide metrics.
    

## AWS Deployment

## Backend

The backend is deployed on **AWS Elastic Beanstalk** with the following setup:

1.  **Application Deployment**:
    
    *   Built as a JAR file using Maven and uploaded to Elastic Beanstalk.
        
2.  **Database**:
    
    *   MySQL database hosted on **AWS RDS** with a preconfigured connection string.
        
3.  **Domain and SSL**:
    
    *   **Default Domain**: Provided by AWS Elastic Beanstalk (HTTP).
        
        *   Link: http://backend-env.eba-mpeky2ew.ap-south-1.elasticbeanstalk.com/
            
    *   **Custom Domain**: Set up for HTTPS using **AWS Certificate Manager**.
        
        *   Link: https://api.simple-portfolio-tracker.site/
            
    *   Steps:
        
        *   Purchased a domain.
            
        *   Linked the subdomain to the Elastic Beanstalk environment.
            
        *   Configured SSL using AWS Certificate Manager and added an HTTPS listener on port 443.
            

## Frontend

The frontend is deployed on **Netlify** for seamless integration and ease of use:

*   Deployment URL: [https://simple-portfolio-tracker-capx.netlify.app/](https://simple-portfolio-tracker-capx.netlify.app/)
*   Frontend GitHub URL: https://github.com/Biku2004/Portfolio-angular
    

### Links

*   **Deployed Frontend**: [Netlify Deployment](https://simple-portfolio-tracker-capx.netlify.app/)
    
*   **Default Deployed Backend from AWS**: [AWS Deployment](http://backend-env.eba-mpeky2ew.ap-south-1.elasticbeanstalk.com/)
    
*   **Live API Documentation**: [API Documentation](https://api.simple-portfolio-tracker.site/)(domain-attached-https-link)
