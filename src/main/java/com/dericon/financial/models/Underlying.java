package com.dericon.financial.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Underlying {

    private String name;

    @JsonCreator
    public Underlying(@JsonProperty("name") String name) {
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
        return "Underlying{" +
                "name='" + name + '\'' +
                '}';
    }
}
