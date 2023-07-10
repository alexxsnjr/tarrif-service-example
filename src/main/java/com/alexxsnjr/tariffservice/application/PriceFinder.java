package com.alexxsnjr.tariffservice.application;

import com.alexxsnjr.tariffservice.domain.NotAvailableTariff;
import com.alexxsnjr.tariffservice.domain.TariffRepository;
import java.util.Comparator;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PriceFinder {

    private final TariffRepository repository;

    public PriceResponse findPriceByProductBrandAndDate(Long productId, Long brandId, Date date)
        throws NotAvailableTariff {
        var availableTariff = repository
            .findPriceByProductBrandAndDate(productId, brandId, date)
            .stream()
            .max(Comparator.comparingLong(x -> x.getPriority().getPriority()))
            .orElseThrow(() -> new NotAvailableTariff("There is no tariff available"));

        return PriceResponse.of(availableTariff);
    }


}
