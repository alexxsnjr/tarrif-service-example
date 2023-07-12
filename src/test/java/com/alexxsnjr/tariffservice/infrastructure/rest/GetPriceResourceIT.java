package com.alexxsnjr.tariffservice.infrastructure.rest;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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

    @ParameterizedTest
    @CsvSource({
        "2020-06-14 10:00:00, 35.5",
        "2020-06-14 16:00:00, 25.45",
        "2020-06-14 21:00:00, 35.5",
        "2020-06-15 10:00:00, 30.5",
        "2020-06-16 21:00:00, 38.95"
    })
    void testGetPrices_shouldReturnCorrectTariffAndHttpOk(String dateString, double expectedPrice)
        throws Exception {
        Long productId = 35455L;
        Long brandId = 1L;

        mockMvc.perform(MockMvcRequestBuilders.get("/api/prices")
                .param("date", dateString)
                .param("productId", "35455")
                .param("brandId", "1")
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.productId").value(productId))
            .andExpect(MockMvcResultMatchers.jsonPath("$.brandId").value(brandId))
            .andExpect(MockMvcResultMatchers.jsonPath("$.finalPrice").value(expectedPrice));

    }


    @ParameterizedTest
    @CsvSource({
        ", 35455, 1, Required request parameter 'date' for method parameter type Date is not present",
        "2020-06-14 10:00:00, , 1, Required request parameter 'productId' for method parameter type Long is not present",
        "2020-06-14 10:00:00, 35455, ,Required request parameter 'brandId' for method parameter type Long is not present"
    })
    void testGetPrices_shouldReturnBadRequest(String dateString, String productId, String brandId,
        String result) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/prices")
                .param("date", dateString)
                .param("productId", productId)
                .param("brandId", brandId)
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isBadRequest())
            .andExpect(MockMvcResultMatchers.jsonPath("$.errors[1]").value(result));
    }

    @ParameterizedTest
    @CsvSource({
        "2020-06-14 10:00:00, 'aaa', 1",
        "2020-06-14 10:00:00, 35455, 'bbb'"
    })
    void testGetPrices_shouldReturnBadRequestForInvalidParameters(String dateString,
        String productId, String brandId) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/prices")
                .param("date", dateString)
                .param("productId", productId)
                .param("brandId", brandId)
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isBadRequest())
            .andExpect(MockMvcResultMatchers.jsonPath("$.errors[1]").isString());
    }

    @ParameterizedTest
    @CsvSource({
        "2020-06-14 10:00:00 CEST 2020, 35455, 5",
        "2020-06-14 10:00:00 CEST 2020, 99999, 1"
    })
    void testGetPrices_shouldReturnNotFoundForNotAvailableTariff(String dateString,
        String productId, String brandId) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/prices")
                .param("date", dateString)
                .param("productId", productId)
                .param("brandId", brandId)
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isNotFound())
            .andExpect(MockMvcResultMatchers.jsonPath("$.errors[1]")
                .value("No Tariff found for product " + productId + " and brand " + brandId
                    + " on Sun Jun 14 10:00:00 CEST 2020"));
    }

}