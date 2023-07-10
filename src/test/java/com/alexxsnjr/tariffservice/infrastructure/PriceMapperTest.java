package com.alexxsnjr.tariffservice.infrastructure;

import com.alexxsnjr.tariffservice.PriceFactory;
import com.alexxsnjr.tariffservice.domain.Tariff;
import com.alexxsnjr.tariffservice.infrastructure.persistence.PriceEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class PriceMapperTest {

    private PriceMapper priceMapper;

    @BeforeEach
    void setup() {
        priceMapper = new PriceMapper();
    }

    @Test
    void testToDomain_ShouldMapPriceEntityToTariff() {
        PriceEntity priceEntity = PriceFactory.givenPriceEntity();

        Tariff tariff = priceMapper.toDomain(priceEntity);

        Assertions.assertNotNull(tariff);
        Assertions.assertEquals(priceEntity.getPriceList(), tariff.getPriceId().getId());
        Assertions.assertEquals(priceEntity.getProductId(), tariff.getProductId().getId());
        Assertions.assertEquals(priceEntity.getBrandId(), tariff.getBrandId().getId());
        Assertions.assertEquals(priceEntity.getPrice(), tariff.getPrice().getAmount());
        Assertions.assertEquals(priceEntity.getCurrency(), tariff.getPrice().getCurrency());
        Assertions.assertEquals(priceEntity.getStartDate(), tariff.getPriceDate().getStartDate());
        Assertions.assertEquals(priceEntity.getEndDate(), tariff.getPriceDate().getEndDate());
        Assertions.assertEquals(priceEntity.getPriority(), tariff.getPriority().getPriority());
    }

}
