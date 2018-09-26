package com.dericon.financial.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Derived {

    private Issuer issuer;

    private Underlying underlying;

    @JsonCreator
    public Derived(@JsonProperty("issuer") Issuer issuer,
                   @JsonProperty("underlying") Underlying underlying) {
        this.issuer = issuer;
        this.underlying = underlying;
    }

    public Issuer getIssuer() {
        return issuer;
    }

    public void setIssuer(Issuer issuer) {
        this.issuer = issuer;
    }

    public Underlying getUnderlying() {
        return underlying;
    }

    public void setUnderlying(Underlying underlying) {
        this.underlying = underlying;
    }

    @Override
    public String toString() {
        return "Derived{" +
                "issuer=" + issuer +
                ", underlying=" + underlying +
                '}';
    }
}
