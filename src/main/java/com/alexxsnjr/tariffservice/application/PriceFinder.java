package com.alexxsnjr.tariffservice.application;

import com.alexxsnjr.tariffservice.domain.NotAvailableTariff;
import com.alexxsnjr.tariffservice.domain.Tariff;
import com.alexxsnjr.tariffservice.domain.TariffRepository;
import java.util.Comparator;
import java.util.Date;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PriceFinder {

    private final TariffRepository repository;

    public Tariff findPriceByProductBrandAndDate(Long productId, Long brandId, Date date)
        throws NotAvailableTariff {

        var availableTariff = repository
            .findPriceByProductBrandAndDate(productId, brandId, date)
            .stream()
            .max(Comparator.naturalOrder())
            .orElseThrow(() -> new NotAvailableTariff("There is no tariff available",
                productId, brandId, date));

        return availableTariff;
    }


}
