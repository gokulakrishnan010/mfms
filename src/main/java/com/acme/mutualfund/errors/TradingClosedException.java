package com.acme.mutualfund.errors;


public class TradingClosedException extends RuntimeException {
    public TradingClosedException(String code) {
        super(code);
    }
}