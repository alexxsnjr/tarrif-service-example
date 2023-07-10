package com.alexxsnjr.tariffservice.infrastructure.rest;

import java.util.Date;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PriceResponse {

    private Long productId;
    private Long brandId;
    private Double tariff;
    private Double finalPrice;
    private Date startDate;
    private Date endDate;
}
