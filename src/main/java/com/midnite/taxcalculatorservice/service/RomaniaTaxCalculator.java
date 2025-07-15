package com.midnite.taxcalculatorservice.service;

import com.midnite.taxcalculatorservice.model.TaxPayer;

public class RomaniaTaxCalculator implements TaxCalculator {
    public double calculateTax(TaxPayer taxPayer) {
        // Romania has a flat tax rate of 10% on income
        double taxRate = 0.10;
        double taxRateCAS = 0.25;
        double taxRateCASS = 0.10;

        // calculate taxRates of CAS and CASS
        double remainAfterFirstInstanceOfTax = taxPayer.getIncome() - (taxPayer.getIncome() * taxRateCAS + taxPayer.getIncome() * taxRateCASS);

        double taxedIncome = taxPayer.getIncome() * taxRateCAS + taxPayer.getIncome() * taxRateCASS +
                remainAfterFirstInstanceOfTax * taxRate;

        if(taxPayer.isPension()) {
            taxedIncome += taxPayer.getIncome() * 0.0475; // 4.75% pension contribution
        }

        return taxedIncome;
    }
}
