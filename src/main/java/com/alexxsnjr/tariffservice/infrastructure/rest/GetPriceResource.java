package com.alexxsnjr.tariffservice.infrastructure.rest;

import com.alexxsnjr.tariffservice.application.PriceResponse;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/prices")
@Slf4j
public class GetPriceResource {

    @GetMapping
    public ResponseEntity<PriceResponse> getTariff(
        @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date date,
        @RequestParam("productId") Long productId,
        @RequestParam("brandId") Long brandId) {

        log.info("Get prices for productId: " + productId);
        PriceResponse tariff = PriceResponse.builder()
            .productId(productId)
            .brandId(brandId)
            .tariffId(2L)
            .finalPrice(2.0)
            .startDate(new Date())
            .endDate(new Date())
            .build();
        return new ResponseEntity<>(tariff, HttpStatus.OK);
    }
}


