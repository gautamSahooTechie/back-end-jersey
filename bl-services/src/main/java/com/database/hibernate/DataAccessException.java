package com.database.hibernate;

/**
 * 
 * @author Gautam Sahoo
 * This exception designed to handle DataAccessException by DataBase
 */
public class DataAccessException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DataAccessException(String message) {
		super(message);
	}
	
	public DataAccessException(String message, Throwable t) {
		super(message, t);
	}
	
	// Override more for your User related information
}
