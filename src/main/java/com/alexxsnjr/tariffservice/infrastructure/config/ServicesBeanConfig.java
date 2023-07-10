package com.alexxsnjr.tariffservice.infrastructure.config;

import com.alexxsnjr.tariffservice.application.PriceFinder;
import com.alexxsnjr.tariffservice.domain.TariffRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *This class defines the application layer beans
 * to decouple the spring framework from the application layer.
 */
@Configuration
@RequiredArgsConstructor
public class ServicesBeanConfig {

    private final TariffRepository tariffRepository;

    @Bean
    public PriceFinder priceFinder() {
        return new PriceFinder(tariffRepository);
    }
}
