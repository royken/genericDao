package com.royken.generic.dao;

/**
 *
 * @author KENFACK Valmy-Roi <roykenvalmy@gmail.com>
 * 
 * 
 */
public class DataAccessException extends Exception{

    public DataAccessException() {
    }

    public DataAccessException(String message) {
        super(message);
    }

    public DataAccessException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataAccessException(Throwable cause) {
        super(cause);
    }

    public DataAccessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
