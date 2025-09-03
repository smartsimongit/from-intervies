package org.smart.simon.livecoding.demo1.model;

import java.util.Objects;
import java.util.UUID;

public class Product {
    private Long id;
    private String name;
    private UUID barcode;

    public Product(Long id, String name, UUID barcode) {
        this.id = id;
        this.name = name;
        this.barcode = barcode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getBarcode() {
        return barcode;
    }

    public void setBarcode(UUID barcode) {
        this.barcode = barcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(getId(), product.getId()) && Objects.equals(getName(), product.getName()) && Objects.equals(getBarcode(), product.getBarcode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getBarcode());
    }
}
