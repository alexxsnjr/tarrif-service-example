package com.alexxsnjr.tariffservice.domain;

import java.util.Date;

public class NotAvailableTariff extends Exception {

    private final Long productId;
    private final Long brandId;
    private final Date date;

    public NotAvailableTariff(String message, Long productId, Long brandId, Date date) {
        super(message);
        this.productId = productId;
        this.brandId = brandId;
        this.date = date;
    }

    public String getMessage() {
        return "No Tariff found for product " + productId
            + " and brand " + brandId
            + " on " + date;
    }
}
