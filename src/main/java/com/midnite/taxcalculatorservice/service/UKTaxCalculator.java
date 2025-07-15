package com.midnite.taxcalculatorservice.service;

import com.midnite.taxcalculatorservice.model.TaxPayer;

public class UKTaxCalculator implements TaxCalculator {
    public double calculateTax(TaxPayer taxPayer) {
        double income = taxPayer.getIncome();
        double taxedMoney = 0;
        if (income <= 12570) taxedMoney = 0;
        else if (income <= 50270) {
            taxedMoney = (income - 12570) * 0.25; // 20% tax rate
        } else {
            taxedMoney = (50270 - 12570) * 0.20 + (income - 50270) * 0.40; // 20% on income up to 50270, 40% on income above that
        }

        if(taxPayer.isPension()) {
            taxedMoney += income * 0.03; // 3% pension contribution
        }

        return taxedMoney;
    }
}
