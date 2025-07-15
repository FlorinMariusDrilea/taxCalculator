package com.midnite.taxcalculatorservice.dto;

public class TaxResponse {
    private String name;
    private String country;
    private double income;
    private double taxAmount;
    private double incomeNet;

    public TaxResponse(String name, String country, double income, double taxAmount, double incomeNet) {
        this.name = name;
        this.country = country;
        this.income = income;
        this.taxAmount = taxAmount;
        this.incomeNet = incomeNet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public double getIncomeNet() {
        return incomeNet;
    }

    public void setIncomeNet(double incomeNet) {
        this.incomeNet = incomeNet;
    }
}
