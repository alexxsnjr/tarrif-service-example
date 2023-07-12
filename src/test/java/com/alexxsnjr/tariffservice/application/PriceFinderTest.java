package com.alexxsnjr.tariffservice.application;

import static org.mockito.Mockito.when;

import com.alexxsnjr.tariffservice.TariffFactory;
import com.alexxsnjr.tariffservice.domain.NotAvailableTariff;
import com.alexxsnjr.tariffservice.domain.Tariff;
import com.alexxsnjr.tariffservice.domain.TariffRepository;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class PriceFinderTest {

    @Mock
    private TariffRepository repository;

    private PriceFinder priceFinder;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        priceFinder = new PriceFinder(repository);
    }

    @Test
    void testFindPriceByProductBrandAndDate_WhenAvailableTariff_ShouldReturnPriceResponse()
        throws NotAvailableTariff {
        Long productId = TariffFactory.DEFAULT_PRODUCT_ID_VALUE;
        Long brandId = TariffFactory.DEFAULT_BRAND_ID_VALUE;
        Date date = new Date();

        Tariff availableTariff = TariffFactory.givenTariff();

        List<Tariff> tariffs = Collections.singletonList(availableTariff);

        when(repository.findPriceByProductBrandAndDate(productId, brandId, date))
            .thenReturn(tariffs);

        var result = priceFinder.findPriceByProductBrandAndDate(productId, brandId, date);

        Assertions.assertEquals(availableTariff.getPriceId().getId(), result.getPriceId().getId());
        Assertions.assertEquals(productId, result.getProductId().getId());
        Assertions.assertEquals(brandId, result.getBrandId().getId());
        Assertions.assertEquals(availableTariff.getPriceDate().getStartDate(),
            result.getPriceDate().getStartDate());
        Assertions.assertEquals(availableTariff.getPriceDate().getEndDate(), result.getPriceDate().getEndDate());
        Assertions.assertEquals(availableTariff.getPrice().getAmount(), result.getPrice().getAmount());
    }

    @Test
    void testFindPriceByProductBrandAndDate_WhenNoAvailableTariff_ShouldThrowNotAvailableTariff() {
        Long productId = TariffFactory.DEFAULT_PRODUCT_ID_VALUE;
        Long brandId = TariffFactory.DEFAULT_BRAND_ID_VALUE;
        Date date = new Date();

        List<Tariff> tariffs = List.of();

        when(repository.findPriceByProductBrandAndDate(productId, brandId, date)).thenReturn(
            tariffs);

        Assertions.assertThrows(NotAvailableTariff.class, () -> {
            priceFinder.findPriceByProductBrandAndDate(productId, brandId, date);
        });
    }

    @Test
    void testFindPriceByProductBrandAndDate_WhenMultipleAvailableTariffs_ShouldReturnHighestPriorityTariff()
        throws NotAvailableTariff {
        Long productId = TariffFactory.DEFAULT_PRODUCT_ID_VALUE;
        Long brandId = TariffFactory.DEFAULT_BRAND_ID_VALUE;
        Date date = new Date();

        Tariff lowPriorityTariff = TariffFactory.givenTariffWithLowPriority();
        Tariff highPriorityTariff = TariffFactory.givenTariff();

        List<Tariff> tariffs = Arrays.asList(lowPriorityTariff, highPriorityTariff);

        when(repository.findPriceByProductBrandAndDate(productId, brandId, date)).thenReturn(
            tariffs);

        var result = priceFinder.findPriceByProductBrandAndDate(productId, brandId, date);

        Assertions.assertEquals(highPriorityTariff.getPriceId().getId(), result.getPriceId().getId());
        Assertions.assertEquals(productId, result.getProductId().getId());
        Assertions.assertEquals(brandId, result.getBrandId().getId());
        Assertions.assertEquals(highPriorityTariff.getPriceDate().getStartDate(),
            result.getPriceDate().getStartDate());
        Assertions.assertEquals(highPriorityTariff.getPriceDate().getEndDate(),
            result.getPriceDate().getEndDate());
        Assertions.assertEquals(highPriorityTariff.getPrice().getAmount(), result.getPrice().getAmount());
    }
}