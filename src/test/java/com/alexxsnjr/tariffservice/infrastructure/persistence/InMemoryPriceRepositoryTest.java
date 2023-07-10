package com.alexxsnjr.tariffservice.infrastructure.persistence;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.alexxsnjr.tariffservice.PriceFactory;
import com.alexxsnjr.tariffservice.domain.Tariff;
import com.alexxsnjr.tariffservice.infrastructure.PriceMapper;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class InMemoryPriceRepositoryTest {

    @Mock
    private JpaPriceRepository jpaRepository;

    @Mock
    private PriceMapper mapper;

    @InjectMocks
    private InMemoryPriceRepository priceRepository;


    @Test
    void testFindPriceByProductBrandAndDate_WhenMatchingRecords_ShouldReturnListOfTariffs() {
        Long productId = PriceFactory.DEFAULT_PRODUCT_ID_VALUE;
        Long brandId = PriceFactory.DEFAULT_BRAND_ID_VALUE;
        Date date = PriceFactory.DEFAULT_DATE;

        List<PriceEntity> priceEntities = PriceFactory.givenPriceEntityList();

        when(
            jpaRepository.findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
                productId, brandId, date, date)).thenReturn(priceEntities);

        List<Tariff> result = priceRepository.findPriceByProductBrandAndDate(productId, brandId,
            date);

        Assertions.assertEquals(2, result.size());
        verify(mapper, times(2)).toDomain(any(PriceEntity.class));
    }

    @Test
    void testFindPriceByProductBrandAndDate_WhenNoMatchingRecords_ShouldReturnEmptyList() {
        Long productId = PriceFactory.DEFAULT_PRODUCT_ID_VALUE;
        Long brandId = PriceFactory.DEFAULT_BRAND_ID_VALUE;
        Date date = PriceFactory.DEFAULT_DATE;
        List<PriceEntity> priceEntities = new ArrayList<>();

        when(
            jpaRepository.findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
                productId, brandId, date, date)).thenReturn(priceEntities);

        List<Tariff> result = priceRepository.findPriceByProductBrandAndDate(productId, brandId,
            date);

        Assertions.assertTrue(result.isEmpty());
        verify(mapper, never()).toDomain(any(PriceEntity.class));
    }

}
