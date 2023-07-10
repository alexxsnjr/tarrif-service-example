package com.alexxsnjr.tariffservice.infrastructure.persistence;

import com.alexxsnjr.tariffservice.domain.Tariff;
import com.alexxsnjr.tariffservice.domain.TariffRepository;
import com.alexxsnjr.tariffservice.infrastructure.PriceMapper;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class InMemoryPriceRepository implements TariffRepository {

    private final JpaPriceRepository jpaRepository;
    private final PriceMapper mapper;

    @Override
    public List<Tariff> findPriceByProductBrandAndDate(Long productId, Long brandId, Date date) {
        log.info("search price by productId:" + productId + " brandId: " + brandId + " and date: "
            + date.toString());
        return jpaRepository
            .findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(productId,
                brandId, date, date)
            .stream()
            .map(mapper::toDomain)
            .collect(Collectors.toList());
    }
}
