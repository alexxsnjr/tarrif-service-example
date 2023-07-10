package com.alexxsnjr.tariffservice.domain;

import java.util.Date;
import java.util.List;

public interface TariffRepository {

    List<Tariff> findPriceByProductBrandAndDate(Long productId, Long brandId, Date date);
}
