package com.midnite.taxcalculatorservice.service;

import com.midnite.taxcalculatorservice.model.TaxPayer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServiceTests {

    @Test
    void romaniaTaxShouldBe10PercentFlat() {
        TaxCalculator calculator = new RomaniaTaxCalculator();
        TaxPayer user = new TaxPayer("John", "Romania", 10000, false);
        double tax = calculator.calculateTax(user);
        assertEquals(4150, tax, 0.01);
    }

    @Test
    void ukTaxShouldCalculateCorrectlyAcrossBands() {
        TaxCalculator calculator = new UKTaxCalculator();
        TaxPayer user = new TaxPayer("Alice", "UK", 60000, false);

        double tax = calculator.calculateTax(user);
        assertEquals(11432.0, tax, 0.01);
    }

    @Test
    void pensionShouldReduceTaxInRomaniaIfImplemented() {
        TaxCalculator calculator = new RomaniaTaxCalculator();
        TaxPayer user = new TaxPayer("Eva", "Romania", 50000, true);
        double tax = calculator.calculateTax(user);

        assertEquals(23125.0, tax, 0.01);
    }
}
