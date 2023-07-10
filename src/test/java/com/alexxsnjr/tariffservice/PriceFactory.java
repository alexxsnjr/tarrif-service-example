package com.alexxsnjr.tariffservice;

import com.alexxsnjr.tariffservice.infrastructure.persistence.PriceEntity;
import java.util.Date;
import java.util.List;

public class PriceFactory {

    public static final Long DEFAULT_PRICE_ID_VALUE = 1L;
    public static final Long DEFAULT_PRODUCT_ID_VALUE = 2L;
    public static final Long DEFAULT_BRAND_ID_VALUE = 3L;
    public static final Date DEFAULT_DATE = new Date();

    public static PriceEntity givenPriceEntity(Long priceList, Long productId, Long brandId, Date startDate, Date endDate) {
        return PriceEntity.builder()
            .priceList(priceList)
            .productId(productId)
            .brandId(brandId)
            .startDate(startDate)
            .endDate(endDate)
            .build();
    }

    public static PriceEntity givenPriceEntity() {
        return PriceEntity.builder()
            .priceList(DEFAULT_PRICE_ID_VALUE)
            .productId(DEFAULT_PRODUCT_ID_VALUE)
            .brandId(DEFAULT_BRAND_ID_VALUE)
            .startDate(DEFAULT_DATE)
            .endDate(DEFAULT_DATE)
            .build();
    }

    public static List<PriceEntity> givenPriceEntityList() {
        PriceEntity priceEntity1 = givenPriceEntity(1L, DEFAULT_PRODUCT_ID_VALUE, DEFAULT_BRAND_ID_VALUE, new Date(), new Date());
        PriceEntity priceEntity2 = givenPriceEntity(2L, DEFAULT_PRODUCT_ID_VALUE, DEFAULT_BRAND_ID_VALUE, new Date(), new Date());;

        return List.of(priceEntity1, priceEntity2);
    }
}
