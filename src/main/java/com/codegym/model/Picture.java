package com.codegym.model;

import javax.persistence.*;

@Entity
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;
    private String height;
    private String wide;
    private String material;
    private String description;
    private double price;
    @ManyToOne
    @JoinColumn(name = "c_id")
    private Catalog catalog;
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Picture() {
    }

    public Picture(String code, String height, String wide, String material, String description, double price, Catalog catalog) {
        this.code = code;
        this.height = height;
        this.wide = wide;
        this.material = material;
        this.description = description;
        this.price = price;
        this.catalog = catalog;
    }

    public Picture(String code, String height, String wide, String material, String description, double price) {
        this.code = code;
        this.height = height;
        this.wide = wide;
        this.material = material;
        this.description = description;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWide() {
        return wide;
    }

    public void setWide(String wide) {
        this.wide = wide;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    @Override
    public String toString() {
        return String.format("Picture[id=%d, code='%s', height='%s', wide='%s', material='%s', description='%s', price='%s']",
                id, code, height, wide, material, description, price);
    }

}
