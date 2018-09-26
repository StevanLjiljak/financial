package com.dericon.financial.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Issuer {

    private String name;

    @JsonCreator
    public Issuer(@JsonProperty("name") String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Issuer{" +
                "name='" + name + '\'' +
                '}';
    }
}
