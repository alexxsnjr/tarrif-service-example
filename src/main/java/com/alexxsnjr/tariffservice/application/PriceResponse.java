package com.alexxsnjr.tariffservice.application;

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
}
