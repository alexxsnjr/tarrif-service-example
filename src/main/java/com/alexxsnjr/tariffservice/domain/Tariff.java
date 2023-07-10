package com.alexxsnjr.tariffservice.domain;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Tariff implements Comparable<Tariff>{

    private PriceId priceId;
    private ProductId productId;
    private BrandId brandId;
    private PriceDate priceDate;
    private Price price;
    private Priority priority;

    @Override
    public int compareTo(Tariff other) {
        return Long.compare(this.priority.getPriority(), other.priority.getPriority());
    }
}
