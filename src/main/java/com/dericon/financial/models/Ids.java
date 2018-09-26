package com.dericon.financial.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Ids {

    private String isin;

    private String wkn;

    private String vwd;

    @JsonCreator
    public Ids(@JsonProperty("isin") String isin,
               @JsonProperty("wkn") String wkn,
               @JsonProperty("vwd") String vwd) {
        this.isin = isin;
        this.wkn = wkn;
        this.vwd = vwd;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public String getWkn() {
        return wkn;
    }

    public void setWkn(String wkn) {
        this.wkn = wkn;
    }

    public String getVwd() {
        return vwd;
    }

    public void setVwd(String vwd) {
        this.vwd = vwd;
    }

    @Override
    public String toString() {
        return "Ids{" +
                "isin='" + isin + '\'' +
                ", wkn='" + wkn + '\'' +
                ", vwd='" + vwd + '\'' +
                '}';
    }
}
