package com.midnite.taxcalculatorservice.model;

public class TaxPayer {
    private String name;
    private String country;
    private double income;
    private boolean pension;

    public TaxPayer(String name, String country, double income, boolean pension) {
        this.name = name;
        this.country = country;
        this.income = income;
        this.pension = pension;
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

    public boolean isPension() {
        return pension;
    }

    public void setPension(boolean pension) {
        this.pension = pension;
    }
}
