package com.alexxsnjr.tariffservice.infrastructure.rest;

import com.alexxsnjr.tariffservice.application.PriceFinder;
import com.alexxsnjr.tariffservice.domain.NotAvailableTariff;
import java.util.Date;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
@Slf4j
public class GetPriceResource {

    private final PriceFinder finder;

    @GetMapping
    public ResponseEntity<PriceResponse> getTariff(
        @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date date,
        @RequestParam("productId") Long productId,
        @RequestParam("brandId") Long brandId) throws NotAvailableTariff {
        log.info("Get prices for productId: " + productId);
        var tariff = finder.findPriceByProductBrandAndDate(productId, brandId, date);
        return new ResponseEntity<>(PriceResponse.of(tariff), HttpStatus.OK);
    }
}


