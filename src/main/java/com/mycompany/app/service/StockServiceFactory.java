package com.mycompany.app.service;

/**
 * A factory class for StockService
 *
 * @author Linda M Roseberry
 */
public class StockServiceFactory {

/**
* Constructor 
*/
    public StockServiceFactory() {
    }

/**
* Constructs a StockService instance
* @return an object that implements the StockService interface
*/

    public static StockService createStockService(){

            return new BasicStockService();
    }
}