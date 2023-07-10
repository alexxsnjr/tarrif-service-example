package com.alexxsnjr.tariffservice.infrastructure;

import com.alexxsnjr.tariffservice.domain.BrandId;
import com.alexxsnjr.tariffservice.domain.Price;
import com.alexxsnjr.tariffservice.domain.PriceDate;
import com.alexxsnjr.tariffservice.domain.PriceId;
import com.alexxsnjr.tariffservice.domain.Priority;
import com.alexxsnjr.tariffservice.domain.ProductId;
import com.alexxsnjr.tariffservice.domain.Tariff;
import com.alexxsnjr.tariffservice.infrastructure.persistence.PriceEntity;
import java.util.Date;

public class PriceMapper {

    public Tariff toDomain(PriceEntity entity) {
        return Tariff.builder()
            .priceId(toPriceId(entity.getPriceList()))
            .productId(toProductId(entity.getProductId()))
            .brandId(toBrandId(entity.getBrandId()))
            .priceDate(toPriceDate(entity.getStartDate(), entity.getEndDate()))
            .price(toPrice(entity.getPrice(), entity.getCurrency()))
            .priority(toPriority(entity.getPriority()))
            .build();
    }

    private Priority toPriority(Long priority) {
        return Priority.builder()
            .priority(priority)
            .build();
    }

    private Price toPrice(Double price, String currency) {
        return Price.builder()
            .amount(price)
            .currency(currency).build();
    }

    private PriceDate toPriceDate(Date startDate, Date endDate) {
        return PriceDate.builder()
            .startDate(startDate)
            .endDate(endDate)
            .build();
    }

    private BrandId toBrandId(Long brandId) {
        return BrandId.builder()
            .id(brandId)
            .build();
    }

    private ProductId toProductId(Long productId) {
        return ProductId.builder()
            .id(productId)
            .build();
    }

    private PriceId toPriceId(Long priceList) {
        return PriceId.builder()
            .id(priceList)
            .build();
    }

}
