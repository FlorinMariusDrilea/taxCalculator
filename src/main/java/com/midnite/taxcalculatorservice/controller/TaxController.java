package com.midnite.taxcalculatorservice.controller;

import com.midnite.taxcalculatorservice.dto.TaxRequest;
import com.midnite.taxcalculatorservice.dto.TaxResponse;
import com.midnite.taxcalculatorservice.model.TaxPayer;
import com.midnite.taxcalculatorservice.service.TaxCalculator;
import com.midnite.taxcalculatorservice.service.TaxCalculatorFactory;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tax")
public class TaxController {

    @PostMapping
    public TaxResponse calculateTax(@Valid @RequestBody TaxRequest request) {
        TaxPayer taxPayer = new TaxPayer(request.getName(), request.getCountry(), request.getIncome(), request.isPension());
        TaxCalculator taxCalculator = TaxCalculatorFactory.getCalculator(request.getCountry());

        double tax = taxCalculator.calculateTax(taxPayer);
        return new TaxResponse(
                taxPayer.getName(),
                taxPayer.getCountry(),
                taxPayer.getIncome(),
                tax,
                taxPayer.getIncome() - tax
        );
    }
}
