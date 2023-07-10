package com.alexxsnjr.tariffservice.domain;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Price {

    private Double amount;
    private String currency;
}
