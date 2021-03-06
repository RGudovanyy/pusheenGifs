package com.anviprojects.springIntro.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name="GIF", uniqueConstraints = {@UniqueConstraint(columnNames = {"name", "id"})})
public class Gif implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private int categoryId;
    private String name;
    private LocalDate dateUploaded;
    private String username;
    private boolean favorite;

    public Gif(String name, int categoryId, String username, LocalDate dateUploaded, boolean favorite) {
        this.name = name;
        this.categoryId = categoryId;
        this.username = username;
        this.dateUploaded = dateUploaded;
        this.favorite = favorite;
    }

    public Gif() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateUploaded() {
        return dateUploaded;
    }

    public void setDateUploaded(LocalDate dateUploaded) {
        this.dateUploaded = dateUploaded;
    }

    public String getUsername() {
        return username;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }
}
