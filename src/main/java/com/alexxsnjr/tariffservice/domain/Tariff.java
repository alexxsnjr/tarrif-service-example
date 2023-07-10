package com.alexxsnjr.tariffservice.domain;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Tariff {

    private PriceId priceId;
    private ProductId productId;
    private BrandId brandId;
    private PriceDate priceDate;
    private Price price;
}
