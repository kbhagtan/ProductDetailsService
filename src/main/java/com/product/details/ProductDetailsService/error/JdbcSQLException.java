package com.product.details.ProductDetailsService.error;

public class JdbcSQLException extends RuntimeException{
    String message;
    String sql;
    String state;
    int errorCode;
    Throwable cause;
    String stackTrace;

    public JdbcSQLException(String message,String sql, String state,
     int errorCode, Throwable cause, String stackTrace) {
    }
}
