package com.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Catalog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long c_id;
    private String name;
    @OneToMany(targetEntity = Picture.class)
    private List<Picture> pictures;

    public Catalog(String name, List<Picture> pictures) {
        this.name = name;
        this.pictures = pictures;
    }

    public Catalog() {
    }

    public Catalog(String name) {
        this.name = name;
    }

    public Long getC_id() {
        return c_id;
    }

    public void setC_id(Long c_id) {
        this.c_id = c_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }
}
