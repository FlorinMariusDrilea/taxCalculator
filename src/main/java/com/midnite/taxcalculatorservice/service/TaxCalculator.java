package com.midnite.taxcalculatorservice.service;

import com.midnite.taxcalculatorservice.model.TaxPayer;

public interface TaxCalculator {
    double calculateTax(TaxPayer taxPayer);
}
