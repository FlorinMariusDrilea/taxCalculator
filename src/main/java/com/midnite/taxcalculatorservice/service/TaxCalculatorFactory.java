package com.midnite.taxcalculatorservice.service;

public class TaxCalculatorFactory {
    public static TaxCalculator getCalculator(String country) {
        return switch (country.toLowerCase()) {
            case "romania" -> new RomaniaTaxCalculator();
            case "united kingdom", "uk" -> new UKTaxCalculator();
            default -> throw new IllegalArgumentException("Country not found: " + country);
        };
    }
}
