package com.mycompany.app.service;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.*;


/**
 * JUnit tests for the BasicStockService 
 *
 * @author Linda M Roseberry
 */
public class BasicStockServiceTest {
	private BasicStockService basicStockService;
	private String symbol;
	private double price;
	private Calendar startDate;
	private Calendar endDate;

    @Before
    public void setup() {  
		basicStockService = (BasicStockService) StockServiceFactory.createStockService("BASIC");
		symbol = "APPL";
		price = 163.5;
		startDate = Calendar.getInstance();
		endDate = Calendar.getInstance();
		endDate.add(Calendar.DATE, 2);
    }

	/**
     * Verify the return value has the correct symbol
     */
    @Test
    public final void testGetQuoteOneArgSymPositive() {
		assertTrue("The returned string is correct",basicStockService.getQuote(symbol).getSymbol().equals(symbol));
    }

    /**
     * Verify the return value does not match the expected symbol
     */
    @Test
    public final void testGetQuoteOneArgSymNegative() {
		String expected = "IBM";
        assertFalse("The returned string does not match the expected result", basicStockService.getQuote(symbol).getSymbol().equals(expected));
    }
	
	/**
     * Verify the return value has the correct date
     */
    @Test
    public final void testGetQuoteOneArgDatePositive() {
		assertTrue("The returned date is correct",basicStockService.getQuote(symbol).getQuoteDate().equals(startDate));
    }

    /**
     * Verify the return value does not match the expected date
     */
    @Test
    public final void testGetQuoteOneArgDateNegative() {
        assertFalse("The returned date does not match the expected result", basicStockService.getQuote(symbol).getQuoteDate().equals(endDate));
    }
	
	/**
     * Verify the return value has the correct price
     */
    @Test
    public final void testGetQuoteOneArgPricePositive() {	
		assertTrue("The returned price is correct",basicStockService.getQuote(symbol).getPrice()==(price));
    }

    /**
     * Verify the return value does not match the expected price
     */
    @Test
    public final void testGetQuoteOneArgPriceNegative() {
		Double expectedPrice = 999.9;
        assertFalse("The returned price does not match the expected result", basicStockService.getQuote(symbol).getPrice() == (expectedPrice));
    }
	
	/**
     * Verify that the return value has a correct symbol
     */
	@Test
	public final void testGetQuoteThreeArgsSymPositive() {
		 assertTrue("Symbol returned from return value of getQuote equals parameter string",
                basicStockService.getQuote(symbol, startDate, endDate).get(0).getSymbol().equals(symbol));
	}
	
	/**
     * Verify that the return value has an incorrect symbol
     */
    @Test
    public final void testGetQuoteThreeArgSymNegative() {
        assertFalse("Symbol returned from return value of getQuote equals lowercase-coverted parameter string",
                basicStockService.getQuote(symbol, startDate, endDate).get(0).getSymbol().equals(symbol.toLowerCase()));
    }
	
	/**
     * Verify that the return value has a correct date
     */
	@Test
	public final void testGetQuoteThreeArgsDatePositive() {
		 assertTrue("Date returned from return value of getQuote is correct",
                basicStockService.getQuote(symbol, startDate, endDate).get(0).getQuoteDate().equals(startDate));
	}
	
	/**
     * Verify that the return value is not equal the expected result
     */
    @Test
    public final void testGetQuoteThreeArgDateNegative() {
        assertFalse("Date returned from return value of getQuote is not expected",
                basicStockService.getQuote(symbol, startDate, endDate).get(0).getQuoteDate().equals(endDate));
    } 
	
}

