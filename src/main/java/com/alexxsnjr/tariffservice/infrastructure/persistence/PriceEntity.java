package com.alexxsnjr.tariffservice.infrastructure.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "prices")
public class PriceEntity {

    @Id
    private Long priceList;

    private Long brandId;
    private Date startDate;
    private Date endDate;
    private Long productId;
    private Long priority;
    private Double price;
    private String currency;
    private Date lastUpdate;
    private String lastUpdateBy;
    private Long id;

}