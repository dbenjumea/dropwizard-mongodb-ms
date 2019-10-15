package com.dbenjumea.api;

import com.dbenjumea.util.ObjectIdSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Objects;
import org.bson.types.ObjectId;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class Donut implements Serializable {

    /** The id.*/
    @JsonSerialize(using = ObjectIdSerializer.class)
    private ObjectId id;

    /** The price. */
    @NotNull
    private double price;

    /** The principal flavor.*/
    @NotNull
    private String flavor;

    /**Constructor.*/
    public Donut() {
    }

//getters & setters
//hashcode, equals and toString methods


    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, price, flavor);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Donut other = (Donut) obj;
        return Objects.equal(this.id, other.id)
                && Objects.equal(this.price, other.price)
                && Objects.equal(this.flavor, other.flavor);
    }

    @Override
    public String toString() {
        return "Donut{" +
                "id=" + id +
                ", price=" + price +
                ", flavor='" + flavor + '\'' +
                '}';
    }
}
