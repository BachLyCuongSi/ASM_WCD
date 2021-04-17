package com.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "title")
    private String title;

    @Column(name = "url_image")
    private String url_image;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    List<ProductEntity> products;

    public CategoryEntity() {
    }

    public CategoryEntity(int id, String name, String title, String url_image) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.url_image = url_image;
    }

    public CategoryEntity(String name, String title, String url_image) {
        this.name = name;
        this.title = title;
        this.url_image = url_image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl_image() {
        return url_image;
    }

    public void setUrl_image(String url_image) {
        this.url_image = url_image;
    }
}
