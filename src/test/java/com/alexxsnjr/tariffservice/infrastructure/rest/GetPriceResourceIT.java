package com.alexxsnjr.tariffservice.infrastructure.rest;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class GetPriceResourceIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetPrices() throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = dateFormat.parse("2023-07-14 10:00:00");
        Long productId = 35455L;
        Long brandId = 1L;

        mockMvc.perform(MockMvcRequestBuilders.get("/api/prices")
                .param("date", "2023-07-14 10:00:00")
                .param("productId", "35455")
                .param("brandId", "1")
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.productId").value(productId))
            .andExpect(MockMvcResultMatchers.jsonPath("$.brandId").value(brandId));
    }}