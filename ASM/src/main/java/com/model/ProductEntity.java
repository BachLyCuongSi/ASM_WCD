package com.model;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "category_id")
    private int category_id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;

    @Column(name = "discount")
    private double discount;

    @Column(name = "url_image")
    private String url_image;

    @Column(name = "is_active")
    private boolean is_active;

    @ManyToOne() //EAGER
    @JoinColumn(name = "category_id", insertable = false, updatable = false)
    private CategoryEntity category;

    public ProductEntity() {
    }

    public ProductEntity(int id, int category_id, String name, double price, double discount, String url_image) {
        this.id = id;
        this.category_id = category_id;
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.url_image = url_image;
    }

    public ProductEntity(int category_id, String name, double price, double discount, String url_image, boolean is_active) {
        this.category_id = category_id;
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.url_image = url_image;
        this.is_active = is_active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getUrl_image() {
        return url_image;
    }

    public void setUrl_image(String url_image) {
        this.url_image = url_image;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }
}
