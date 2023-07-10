package com.alexxsnjr.tariffservice.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TariffTest {

    @Test
    void testTariffGiveAggregateIsCompleteShouldReturnTheSameDomainElementsValues() {
        Tariff tariff = TariffFactory.givenTariff();

        Assertions.assertEquals(TariffFactory.DEFAULT_PRICE_ID_VALUE, tariff.getPriceId().getId());
        Assertions.assertEquals(TariffFactory.DEFAULT_PRODUCT_ID_VALUE, tariff.getProductId().getId());
        Assertions.assertEquals(TariffFactory.DEFAULT_BRAND_ID_VALUE, tariff.getBrandId().getId());
        Assertions.assertEquals(TariffFactory.DEFAULT_PRICE_AMOUNT, tariff.getPrice().getAmount());
        Assertions.assertEquals(TariffFactory.DEFAULT_PRICE_CURRENCY, tariff.getPrice().getCurrency());
    }
}