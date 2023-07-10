package com.alexxsnjr.tariffservice.application;

import com.alexxsnjr.tariffservice.domain.Tariff;
import java.util.Date;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PriceResponse {

    private Long productId;
    private Long brandId;
    private Long tariffId;
    private Double finalPrice;
    private Date startDate;
    private Date endDate;

    public static PriceResponse of(Tariff availableTariff) {
        return PriceResponse.builder()
            .tariffId(availableTariff.getPriceId().getId())
            .productId(availableTariff.getProductId().getId())
            .brandId(availableTariff.getBrandId().getId())
            .startDate(availableTariff.getPriceDate().getStartDate())
            .endDate(availableTariff.getPriceDate().getEndDate())
            .finalPrice(availableTariff.getPrice().getAmount())
            .build();
    }
}
