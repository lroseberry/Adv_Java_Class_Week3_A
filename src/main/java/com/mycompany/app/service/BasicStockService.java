package com.mycompany.app.service;

import java.util.*;
import java.text.SimpleDateFormat;
import com.mycompany.app.model.*;

/**
 * BasicStockService provides a concrete implementation of StockService interface
 *
 * @author Linda M Roseberry
 */

class BasicStockService implements StockService {

    // Hard code price for now
    private double price = 163.50;
    Calendar currdate = Calendar.getInstance();

    @Override
    public StockQuote getQuote(String symbol) {
        return new StockQuote(currdate, price, symbol);
    }

    /**
     * Gets the {@code List} of {@code StockQuote} instances for the given symbol and date range
     * @param symbol symbol for the company issuing the stock
     * @param startDate beginning of the date range
     * @param endDate end of the date range
     * @return a {@code List} of {@code StockQuote} instances
     */
    @Override
    public List<StockQuote> getQuote(String symbol, Calendar startDate, Calendar endDate) {

        List<StockQuote> stockQuotesList = new ArrayList<StockQuote>();

        while (startDate.after(startDate) || startDate.equals(startDate) && startDate.before(endDate) || startDate.equals(endDate)) {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            System.out.println("Quote date: " + sdf.format(startDate.getTime()) + "  Symbol: " + symbol + "  Price: " + price);
            stockQuotesList.add(new StockQuote(startDate, price, symbol));
            price = price + 1;
            startDate.add(Calendar.DATE, 1);
        }
        return stockQuotesList;
    }
}