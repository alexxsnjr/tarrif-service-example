package com.alexxsnjr.tariffservice.domain;

import java.util.Date;

public class TariffFactory {

    public static final Long DEFAULT_PRICE_ID_VALUE = 1L;
    public static final Long DEFAULT_PRODUCT_ID_VALUE = 2L;
    public static final Long DEFAULT_BRAND_ID_VALUE = 3L;
    public static final Double DEFAULT_PRICE_AMOUNT = 10.0;
    public static final String DEFAULT_PRICE_CURRENCY = "EUR";

    public static Tariff givenTariff() {
        PriceId priceId = givenPriceId();
        ProductId productId = givenProductId();
        BrandId brandId = givenBrandId();
        PriceDate priceDate = givenPriceDate();
        Price price = givenPrice();

        return Tariff.builder()
            .priceId(priceId)
            .productId(productId)
            .brandId(brandId)
            .priceDate(priceDate)
            .price(price)
            .build();
    }

    private static PriceId givenPriceId() {
        return PriceId.builder()
            .id(DEFAULT_PRICE_ID_VALUE)
            .build();
    }

    private static ProductId givenProductId() {
        return ProductId.builder()
            .id(DEFAULT_PRODUCT_ID_VALUE)
            .build();
    }

    private static BrandId givenBrandId() {
        return BrandId.builder()
            .id(DEFAULT_BRAND_ID_VALUE)
            .build();
    }

    private static PriceDate givenPriceDate() {
        Date startDate = new Date();
        Date endDate = new Date();
        return PriceDate.builder()
            .startDate(startDate)
            .endDate(endDate)
            .build();
    }

    private static Price givenPrice() {
        return Price.builder()
            .amount(DEFAULT_PRICE_AMOUNT)
            .currency(DEFAULT_PRICE_CURRENCY)
            .build();
    }
}