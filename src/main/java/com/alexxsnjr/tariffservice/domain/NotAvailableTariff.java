package com.alexxsnjr.tariffservice.domain;

public class NotAvailableTariff extends Exception {

    public NotAvailableTariff(String message) {
        super(message);
    }
}
