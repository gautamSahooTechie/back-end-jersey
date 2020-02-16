package com.database.hibernate;

public class ExceptionHandler {

	private static String ERROR_CODE = "E000001";
	private static String ERROR_DESCRIPTION = "Fatal Error Occurred during dataBase";
	
	public static DataAccessException throwDataAccessException(String message, String[] inputParameters, Throwable t) {
		String customizeExceptionMessage = appendCustomizedErrorMessage(message, inputParameters, null);
    	return new DataAccessException(customizeExceptionMessage, t);
	}
	
	public static DataAccessException throwDataAccessException(String message, Throwable t) {
    	return new DataAccessException(message, t);
	}
	
	public static DataAccessException throwDataAccessException(String message) {
    	return new DataAccessException(message);
	}
	
	/**
	 * Use below method if you have implemented toString Method
	 * @param message
	 * @param object
	 * @param t
	 * @return
	 */
	public static DataAccessException throwDataAccessException(String message, Object object, Throwable t) {
		String customizeExceptionMessage = appendCustomizedErrorMessage(message, null, object);
    	return new DataAccessException(customizeExceptionMessage, t);
	}
	
	private static String appendCustomizedErrorMessage(String message, String[] inputParameters , Object object){
    	StringBuilder messageBuilder = new StringBuilder();
    	messageBuilder.append(ERROR_CODE);
    	messageBuilder.append(":");
    	messageBuilder.append(ERROR_DESCRIPTION);
    	messageBuilder.append(message);
    	messageBuilder.append("\n");
    	messageBuilder.append("For INPUT parameters:");

    	if(inputParameters != null && inputParameters.length > 0) {
    		messageBuilder.append(inputParameters);
		}
    	
    	if(object != null) {
    		messageBuilder.append(object);
    	}
    	
    	return messageBuilder.toString();
    }
}
