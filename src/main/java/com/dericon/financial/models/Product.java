package com.dericon.financial.models;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class Product {

    private String _id;

    private Derived derived;

    private Ids ids;

    private Figures figures;

    @JsonCreator
    public Product(@JsonProperty("_id") String _id,
                   @JsonProperty("derived") Derived derived,
                   @JsonProperty("ids") Ids ids,
                   @JsonProperty("figures") Figures figures) {
        this._id = _id;
        this.derived = derived;
        this.ids = ids;
        this.figures = figures;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Derived getDerived() {
        return derived;
    }

    public void setDerived(Derived derived) {
        this.derived = derived;
    }

    public Ids getIds() {
        return ids;
    }

    public void setIds(Ids ids) {
        this.ids = ids;
    }

    public Figures getFigures() {
        return figures;
    }

    public void setFigures(Figures figures) {
        this.figures = figures;
    }

    @Override
    public String toString() {
        return "Product{" +
                "_id='" + _id + '\'' +
                ", derived=" + derived +
                ", ids=" + ids +
                ", figures=" + figures +
                '}';
    }
}
