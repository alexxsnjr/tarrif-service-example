package com.alexxsnjr.tariffservice.domain;

import java.util.Date;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PriceDate {

    private Date startDate;
    private Date endDate;

}
