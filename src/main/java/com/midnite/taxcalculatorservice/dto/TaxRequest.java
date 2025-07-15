package com.midnite.taxcalculatorservice.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.jetbrains.annotations.NotNull;

public class TaxRequest {
    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "Country is required")
    private String country;
    @Min(value = 0, message = "Income must be non-negative")
    private double income;
    private boolean pension;

    public TaxRequest(@NotNull String name, @NotNull String country, double income, boolean pension) {
        this.name = name;
        this.country = country;
        this.income = income;
        this.pension = pension;
    }

    public @NotNull String getCountry() {
        return country;
    }

    public void setCountry(@NotNull String country) {
        this.country = country;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPension() {
        return pension;
    }

    public void setPension(boolean pension) {
        this.pension = pension;
    }
}
