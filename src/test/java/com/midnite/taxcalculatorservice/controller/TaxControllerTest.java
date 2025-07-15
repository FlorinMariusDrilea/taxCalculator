package com.midnite.taxcalculatorservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.midnite.taxcalculatorservice.dto.TaxRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TaxController.class)
public class TaxControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void shouldCalculateTaxFromRomania() throws Exception {
        TaxRequest request = new TaxRequest("User1", "romania", 5000, false);

        mockMvc.perform(post("/api/tax")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("User1"))
                .andExpect(jsonPath("$.country").value("romania"))
                .andExpect(jsonPath("$.income").value(5000.0));
    }

    @Test
    public void shouldReturnValidationError() throws Exception {
        TaxRequest request = new TaxRequest("", "romania", 5000, false);

        mockMvc.perform(post("/api/tax")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Name is required"));
    }

    @Test
    void shouldHandleUnsupportedCountry() throws Exception {
        TaxRequest request = new TaxRequest("Florin", "Atlantis", 51000, false);

        mockMvc.perform(post("/api/tax")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().is5xxServerError())
                .andExpect(jsonPath("$.message", containsString("Country not found: Atlantis")));
    }

    @Test
    void shouldRejectNegativeIncome() throws Exception {
        TaxRequest request = new TaxRequest("User", "UK", -1000, false);

        mockMvc.perform(post("/api/tax")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Income must be non-negative"));
    }
}
