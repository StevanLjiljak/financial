package com.dericon.financial.models;

public class ProductNew {

    private String _id;

    private String issuerName;

    private String underlyingName;

    private String isin;

    private Double sideYieldPa;

    public ProductNew() { }

    public ProductNew(String _id, String issuerName, String underlyingName, String isin, Double sideYieldPa) {
        this._id = _id;
        this.issuerName = issuerName;
        this.underlyingName = underlyingName;
        this.isin = isin;
        this.sideYieldPa = sideYieldPa;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getIssuerName() {
        return issuerName;
    }

    public void setIssuerName(String issuerName) {
        this.issuerName = issuerName;
    }

    public String getUnderlyingName() {
        return underlyingName;
    }

    public void setUnderlyingName(String underlyingName) {
        this.underlyingName = underlyingName;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public Double getSideYieldPa() {
        return sideYieldPa;
    }

    public void setSideYieldPa(Double sideYieldPa) {
        this.sideYieldPa = sideYieldPa;
    }

    @Override
    public String toString() {
        return "ProductNew{" +
                "_id='" + _id + '\'' +
                ", issuerName='" + issuerName + '\'' +
                ", underlyingName='" + underlyingName + '\'' +
                ", isin='" + isin + '\'' +
                ", sideYieldPa=" + sideYieldPa +
                '}';
    }
}
