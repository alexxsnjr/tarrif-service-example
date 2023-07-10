package com.alexxsnjr.tariffservice.infrastructure.persistence;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPriceRepository extends JpaRepository<PriceEntity, Long> {

    List<PriceEntity> findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
        Long productId, Long brandId, Date startDate, Date endDate);
}
