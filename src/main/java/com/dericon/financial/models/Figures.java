package com.dericon.financial.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Figures {

    private Double sideYield;

    private Double sideYieldPa;

    @JsonCreator
    public Figures(@JsonProperty("sideYield") Double sideYield,
                   @JsonProperty("sideYieldPa") Double sideYieldPa) {
        this.sideYield = sideYield;
        this.sideYieldPa = sideYieldPa;
    }

    public Double getSideYield() {
        return sideYield;
    }

    public void setSideYield(Double sideYield) {
        this.sideYield = sideYield;
    }

    public Double getSideYieldPa() {
        return sideYieldPa;
    }

    public void setSideYieldPa(Double sideYieldPa) {
        this.sideYieldPa = sideYieldPa;
    }

    @Override
    public String toString() {
        return "Figures{" +
                "sideYield=" + sideYield +
                ", sideYieldPa=" + sideYieldPa +
                '}';
    }
}
