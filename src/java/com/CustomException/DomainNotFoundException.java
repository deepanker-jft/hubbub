package com.CustomException;

/**
 * Created by bhushan on 21/8/16.
 */
public class DomainNotFoundException extends Exception{
    public DomainNotFoundException(String message) {
        super(message);
    }
}
