package com.mycompany.app.application;

import java.util.*;
import java.text.SimpleDateFormat;
import com.mycompany.app.service.*;
import com.mycompany.app.model.*;

public class StockQuoteApplication {

    /**
     * A main method which enables program execution
     *
     * @param args an array that should contain as elements:
     *       {@code String} representations of a symbol, start date, and end date
     */
    public static void main(String[] args) {

        StockServiceFactory stockServiceFactory = new StockServiceFactory();
        StockService basicService = stockServiceFactory.createStockService("BASIC");
		
        StockQuote stockQuote1 = basicService.getQuote(args[0]);
		
		Calendar startDate = formatDate(args[1]);
		Calendar endDate = formatDate(args[2]);
	
        List<StockQuote> stockQuote2 = basicService.getQuote(args[0], startDate, endDate);
	}
  
	 /**
     * Format date string into a Calendar object
     *
     * @param string date to be formatted
	 * @return a Calendar object
     */
	private static Calendar formatDate(String stringDate) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Calendar dt = Calendar.getInstance();
		try {
			dt.setTime(sdf.parse(stringDate));
		}
           catch (Exception e) {
               e.printStackTrace();
           }
		return dt;
	}
}